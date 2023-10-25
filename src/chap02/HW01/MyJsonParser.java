package chap02.HW01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class MyJsonParser {
    public static void main(String[] args) {
        String json = readJSONStringFromKeyboard();
        var map = parseJSONString(json);
        var jsonString = convertHashMapToJsonString(map);
        System.out.println(convertStringToPrettyJson(jsonString));
    }

    public static String readJSONStringFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        while (sc.hasNext()) {
            res.append(sc.nextLine());
        }
        return res.toString();
    }

    public static String removeSpace(String json) {
        StringBuilder tokens = new StringBuilder(), token = new StringBuilder();
        boolean insideString = false;

        for (char c : json.toCharArray()) {
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
            } else if (!insideString && (c == ' ' || c == '{' || c == '}' || c ==  ':' || c== ',')) {
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

    public static ArrayList<Object> parseListString(String listStr) {
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

    public static String[] parseKVPair(String kvPair) {
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

    public static TreeMap<String, Object> parseJSONString(String json) {
        TreeMap<String, Object> map = new TreeMap<>();
        json = removeSpace(json);
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
                if (kvPair[1].startsWith("{") && kvPair[1].endsWith("}")) map.put(kvPair[0], parseJSONString(kvPair[1]));
                else map.put(kvPair[0], kvPair[1]);
                kvPairString.setLength(0);
            } else if (c == ']' && nestedDepth == 1) {
                nestedDepth--;
                kvPairString.append(c);
                kvPair = parseKVPair(kvPairString.toString());
                map.put(kvPair[0], parseListString(kvPair[1]));
                kvPairString.setLength(0);
                isArray = false;
            } else if (c == ',' && isArray) {
                kvPairString.append(c);
            } else if (c == ',' && isNested && nestedDepth > 0) {
                kvPairString.append(c);
            } else if (c == ',' && !kvPairString.isEmpty()) {
                kvPair = parseKVPair(kvPairString.toString());
                map.put(kvPair[0], kvPair[1]);
                isNested = false;
                isArray = false;
                kvPairString.setLength(0);
            } else if (c == ',') {
                isNested = false;
                isArray = false;
                kvPairString.setLength(0);
            } else {
                kvPairString.append(c);
            }
        }
        if (!kvPairString.isEmpty()) {
            kvPair = parseKVPair(kvPairString.toString());
            map.put(kvPair[0], kvPair[1]);
        }
        return map;
    }

    public static String convertHashMapToJsonString(TreeMap<String, Object> json) {
        StringBuilder res = new StringBuilder("{\n");
        int numOfKey = json.size();
        int idx = 0;
        for (String key : json.keySet()) {
            idx++;
            res.append(key).append(": ");
            var value = json.get(key);
            if (value instanceof String) {
                res.append(value);
            } else if (value instanceof ArrayList) {
                ArrayList<Object> arr = (ArrayList<Object>) value;
                res.append("[");
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof String) {
                        res.append(arr.get(i)).append(i == arr.size() - 1 ? "" : ", ");
                    } else if (arr.get(i) instanceof TreeMap<?,?>) {
                        res.append("\n" + convertHashMapToJsonString((TreeMap<String, Object>) arr.get(i)))
                                .append(i == arr.size() - 1 ? "\n" : ",");
                    }
                }
                res.append("]");
            } else if (value instanceof TreeMap) {
                res.append(convertHashMapToJsonString((TreeMap<String, Object>) value));
            }
            if (idx < numOfKey) res.append(",\n");
        }
        res.append("\n}");
        return res.toString();
    }

    public static String convertStringToPrettyJson(String json) {
        StringBuilder res = new StringBuilder();
        int nestedDepth = 0;
        String[] splitArr = json.split("\n");

        for (int i = 0; i < splitArr.length; i++) {
            String token = splitArr[i];

            if (token.startsWith("}") || token.startsWith("]")) {
                nestedDepth--;
            }

            res.append(" ".repeat(nestedDepth * 2)).append(token);  // Apply indentation

            if (token.endsWith("{") || token.endsWith("[")) {
                nestedDepth++;
            }

            if (i != splitArr.length - 1) {
                res.append("\n");
            }
        }
        return res.toString();
    }
}