package com.test.prog.str;

// Java program to print all permutations of a
// given string. 
public class Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.myp(str, 0, n - 1);
    }

    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
				//System.out.println("swap str: "+ str);
				permute(str, l + 1, r);
              /*
				System.out.println("After permute str: "+ str);
                str = swap(str, l, i);
				System.out.println("After permute and swap str: "+ str);*/
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
		//System.out.println("swap "+  charArray[i] + " with "+  charArray[j]);
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public void myp(String str, int b, int e){
    	if(b==e){
			System.out.println(str);
		}else {
    		for (int i=b; i<=e; i++){
    			str = swap(str, b, i);
    			myp(str, b+1, e);

			}
		}
	}

}