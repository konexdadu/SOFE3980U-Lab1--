package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
    private String n = "0";  // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     *
     * @param n a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
     */
    public Binary(String n) {
        if (n == null || n.isEmpty()) {
            this.n = "0"; // Default to "0" for null or empty input
            return;
        }

        // Validate the binary string (only '0' or '1' allowed)
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (ch != '0' && ch != '1') {
                this.n = "0"; // Default to "0" for invalid input
                return;
            }
        }

        // Remove leading zeros
        int beg;
        for (beg = 0; beg < n.length(); beg++) {
            if (n.charAt(beg) != '0') {
                break;
            }
        }

        // If all digits are '0', ensure n is "0"
        this.n = (beg == n.length()) ? "0" : n.substring(beg);

        // uncomment the following code

        if (this.n.isEmpty()) { // replace empty strings with a single zero
            this.n = "0";
        }
    }

    /**
     * Return the binary value of the variable
     *
     * @return the binary value in a string format.
     */
    public String getValue() {
        return this.n;
    }

    /**
     * Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-ns"> Add-Binary-ns </a>.
     *
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1+num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        // the index of the first digit of each n
        int ind1 = num1.n.length() - 1;
        int ind2 = num2.n.length() - 1;
        //initial variable
        int carry = 0;
        String num3 = "";  // the binary value of the sum
        while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
        {
            int sum = carry; // previous carry
            if (ind1 >= 0) { // if num1 has a digit to add
                sum += (num1.n.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind1--; // update ind1
            }
            if (ind2 >= 0) { // if num2 has a digit to add
                sum += (num2.n.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
                ind2--; //update ind2
            }
            carry = sum / 2; // the new carry
            sum = sum % 2;  // the resultant digit
            num3 = ((sum == 0) ? "0" : "1") + num3; //convert sum to string and append it to num3
        }
        Binary result = new Binary(num3);  // create a binary object with the calculated value.
        return result;
    }

    public static Binary or(Binary num1, Binary num2) {
        String s1 = num1.getValue();
        String s2 = num2.getValue();
        String ans = "";
        
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        
        while (i >= 0 || j >= 0) {
            char c1 = (i >= 0) ? s1.charAt(i) : '0';
            char c2 = (j >= 0) ? s2.charAt(j) : '0';
            
            if (c1 == '1' || c2 == '1') {
                ans = "1" + ans;
            } else {
                ans = "0" + ans;
            }
            i--;
            j--;
        }
        return new Binary(ans);
    }

    public static Binary and(Binary num1, Binary num2) {
        String s1 = num1.getValue();
        String s2 = num2.getValue();
        String ans = "";
        
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        
        while (i >= 0 || j >= 0) {
            char c1 = (i >= 0) ? s1.charAt(i) : '0';
            char c2 = (j >= 0) ? s2.charAt(j) : '0';
            
            if (c1 == '1' && c2 == '1') {
                ans = "1" + ans;
            } else {
                ans = "0" + ans;
            }
            i--;
            j--;
        }
        return new Binary(ans);
    }

    public static Binary multiply(Binary num1, Binary num2) {
        String mult = num2.getValue();
        Binary total = new Binary("0");
        
        for (int i = mult.length() - 1; i >= 0; i--) {
            if (mult.charAt(i) == '1') {
                String temp = num1.getValue();
                int zerosToAdd = (mult.length() - 1) - i;
                for (int z = 0; z < zerosToAdd; z++) {
                    temp += "0";
                }
                total = Binary.add(total, new Binary(temp));
            }
        }
        return total;
    }
}