
public class aufgaben {
        public static void main(String[] args) {
            int number = 63;
            double pi = Math.PI;

            // Zeile 1
            System.out.printf("%d      %s%n", number,convertNumberToWords(number) );

            // Zeile 2
            System.out.printf("*      %d*%n", number);

            // Zeile 3
            System.out.printf("*%07d%n", number);

            // Zeile 4
            System.out.printf("*+%d     *%n", number);

            // Zeile 5
            System.out.printf("*%.6f*%n", pi);

            // Zeile 6
            System.out.printf("*        %.6f*%n", pi);

            // Zeile 7
            System.out.printf("*%016.6f*%n", pi);

            // Zeile 8
            System.out.printf("%d%%%n", number);
        }

    public static String convertNumberToWords(int number) {
        if (number >= 0 && number <= 99) {
            String[] tens = {
                    "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
            };
            String[] ones = {
                    "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
            };

            if (number < 20) {
                return ones[number];
            } else {
                int tensDigit = number / 10;
                int onesDigit = number % 10;
                return tens[tensDigit] + (onesDigit != 0 ? "" + ones[onesDigit] : "");
            }
        } else {
            return "Invalid number";
        }}
}




