class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            if (calAge(details[i]) > 60) {
                count++;
            }
        }
        return count;
    }

    public int calAge(String de) {
        // Correctly convert characters to integers
        int age = (de.charAt(11) - '0') * 10 + (de.charAt(12) - '0');
        return age;
    }
}