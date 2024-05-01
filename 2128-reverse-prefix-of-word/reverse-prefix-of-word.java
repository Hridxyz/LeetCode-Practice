class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            // If the character is not found, return the word unchanged
            return word;
        }
        // Reverse the substring from the start to the index where 'ch' is found
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        sb.reverse();
        // Append the rest of the string unchanged
        sb.append(word.substring(index + 1));
        return sb.toString();
    }
}
