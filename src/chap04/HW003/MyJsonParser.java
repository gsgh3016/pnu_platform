package chap04.HW003;

import java.util.ArrayList;
import java.util.HashMap;

public class MyJsonParser {
    private HashMap<String, Object> treeMap;
    private final JsonEscapeCharacterHandler escapeHandler;
    public MyJsonParser() {
        this.treeMap = new HashMap<>();
        this.escapeHandler = new JsonEscapeCharacterHandler();
    }

    public String removeSpace(String json) {
        StringBuilder tokens = new StringBuilder(), token = new StringBuilder();
        boolean insideString = false;
        for (char c: json.toCharArray()) {
            if (c == '\"' && insideString) {
                token.append(c);
                insideString = false;
            } else if (c == '\"' && !insideString) {
                if (!token.isEmpty()) {
                    tokens.append(token);
                    token.setLength(0);
                }
                token.append(c);
                insideString = true;
            } else if (!insideString && (c == ' ' || c == '{' || c == '}' || c == ':' || c == ',')) {
                if (!token.isEmpty()) {
                    tokens.append(token);
                    token.setLength(0);
                }
                if (c == '{' || c == '}' || c == ':' || c == ',') {
                    tokens.append(c);
                }
            } else {
                token.append(c);
            }
        }

        if (!token.isEmpty()) {
            tokens.append(token);
        }

        String res = tokens.toString();
        if (res.length() <= 1) {
            return res;
        }
        return (res.startsWith("{") && res.endsWith("}")) || (res.startsWith("[") && res.endsWith("]")) ?
                tokens.substring(1, tokens.length() - 1) : res;
    }

    public ArrayList<Object> parseListString(String listStr) {
        ArrayList<Object> list = new ArrayList<>();
        int nestedDepth = 0;
        StringBuilder element = new StringBuilder();
        boolean isNested = false;

        for(char c: listStr.toCharArray()) {
            if (c == '{') {
                isNested = true;
                nestedDepth++;
                element.append(c);
            } else if (c == '}') {
                nestedDepth--;
                element.append(c);
            } else if (c == ',' && nestedDepth == 0) {
                if (isNested) list.add(parseJSONString(element.toString()));
                else list.add(element.toString());
                element.setLength(0);
                isNested = false;
            } else if (c == ',' && nestedDepth > 0) {
                element.append(c);
            } else if (c != '[' && c != ']') {
                element.append(c);
            }
        }

        if (!element.isEmpty()) {
            if (isNested) list.add(parseJSONString(element.toString()));
            else list.add(element.toString());
        }

        return list;
    }

    public String[] parseKVPair(String kvPair) {
        String[] kv = new String[2];
        String[] colonSplit = kvPair.split(":");
        if (colonSplit.length == 2) {
            return colonSplit;
        }
        int firstColonIdx = kvPair.indexOf(":");
        kv[0] = kvPair.substring(0, firstColonIdx);
        kv[1] = kvPair.substring(firstColonIdx + 1);
        return kv;
    }

    public HashMap<String, Object> parseJSONString(String json) {
        this.treeMap = new HashMap<>();
        json = removeSpace(json);
        json = this.escapeHandler.handleEscapedCharacters(json);
        int nestedDepth = 0;
        StringBuilder kvPairString = new StringBuilder();
        String[] kvPair;
        boolean isNested = false, isArray = false;

        for(char c: json.toCharArray()) {
            if (c == '{') {
                if (nestedDepth == 0) isNested = true;
                nestedDepth++;
                kvPairString.append(c);
            } else if (c == '[') {
                if (nestedDepth == 0) isArray = true;
                nestedDepth++;
                kvPairString.append(c);
            } else if ((c == '}' || c == ']') && nestedDepth > 1) {
                nestedDepth--;
                kvPairString.append(c);
            } else if (c == '}' && nestedDepth == 1) {
                nestedDepth--;
                kvPairString.append(c);
                kvPair = parseKVPair(kvPairString.toString());
                if (kvPair[1].startsWith("{") && kvPair[1].endsWith("}")) this.treeMap.put(kvPair[0], parseJSONString(kvPair[1]));
                else this.treeMap.put(kvPair[0], kvPair[1]);
                kvPairString.setLength(0);
            } else if (c == ']' && nestedDepth == 1) {
                nestedDepth--;
                kvPairString.append(c);
                kvPair = parseKVPair(kvPairString.toString());
                this.treeMap.put(kvPair[0], parseListString(kvPair[1]));
                kvPairString.setLength(0);
                isArray = false;
            } else if (c == ',' && isArray) {
                kvPairString.append(c);
            } else if (c == ',' && isNested && nestedDepth > 0) {
                kvPairString.append(c);
            } else if (c == ',' && !kvPairString.isEmpty()) {
                kvPair = parseKVPair(kvPairString.toString());
                this.treeMap.put(kvPair[0], kvPair[1]);
                isNested = false;
                isArray = false;
                kvPairString.setLength(0);
            } else if (c == ',') {
                isNested = false;
                isArray = false;
                kvPairString.setLength(0);
            } else if (c !='\"') {
                kvPairString.append(c);
            }
        }
        if (!kvPairString.isEmpty()) {
            kvPair = parseKVPair(kvPairString.toString());
            this.treeMap.put(kvPair[0], kvPair[1]);
        }
        return this.treeMap;
    }

    public HashMap<String, Object> parse(String jsonString) throws Exception {
        return parseJSONString(jsonString);
    }
}
