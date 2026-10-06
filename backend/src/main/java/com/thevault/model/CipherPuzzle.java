package com.thevault.model;

public class CipherPuzzle extends Puzzle {
    private int shift;
    public CipherPuzzle(
        int id,
        String question,
        String answer,
        Difficulty difficulty,
        int shift
) {
    super(id, question, answer, difficulty);
    this.shift = shift;
}
    @Override
public boolean checkAnswer(String answer) {
    return getAnswer().equalsIgnoreCase(answer);
}
    @Override
    public String getHint(){
        return "Try decoding the message using the appropriate cipher";
    }
public String decode(String encryptedText) {

    StringBuilder result = new StringBuilder();

    for (char ch : encryptedText.toCharArray()) {

        if (Character.isLetter(ch)) {

            char base = Character.isUpperCase(ch) ? 'A' : 'a';

            char decoded = (char) ((ch - base - this.shift + 26) % 26 + base);

            result.append(decoded);

        } else {

            result.append(ch);
        }
    }

    return result.toString();
}
public int getShift(){
    return this.shift;
}
}