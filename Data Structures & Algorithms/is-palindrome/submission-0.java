class Solution {
    public boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while(l < r) {
            char lc = Character.toLowerCase(s.charAt(l));
            char rc = Character.toLowerCase(s.charAt(r));

            if(!isAlphaNum(lc)) {
                l++;
                continue;
            }

            if(!isAlphaNum(rc)) {
                r--;
                continue;
            }

            if(lc != rc) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
