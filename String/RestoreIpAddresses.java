public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        for (int i = 0; i <= s.length() - 4; i++) {
            if (isValid(s.substring(0, i + 1))) {
                String str1 = s.substring(0, i + 1);
                for (int j = i + 1; j <= s.length() - 3; j++) {
                    if (isValid(s.substring(i + 1, j + 1))) {
                        String str2 = s.substring(i + 1, j + 1);
                        for (int k = j + 1; k <= s.length() - 2; k++) {
                            if (isValid(s.substring(j + 1, k + 1))) {
                                String str3 = s.substring(j + 1, k + 1);
                                if (isValid(s.substring(k + 1))) {
                                    String str4 = s.substring(k + 1);
                                    res.add(str1 + "." + str2 + "." + str3 + "." + str4);
                                }
                            }
                        }
                    }
                }
            } 
        }
        return res;
    }
    public boolean isValid(String str) {
        if (str == null || str.isEmpty() || str.length() > 3) {
            return false;
        }
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        if (Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }
}
