
class Parser {
    static int parseValue(String str) {
        int result = 0;
        for (String val : str.split(" ")) {
            int num = getNumber(val);
            if (num == 0) {
                switch (val) {
                    case "hundred":
                        result *= 100;
                        break;
                    case "thousand":
                        result *= 1000;
                        break;
                    default:
                        return 0;
                }
            }else{
                result += num;
            }
        }
        return result;
    }

    private static int getNumber(String num) {
        switch (num.toLowerCase()) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "zero":
                return 0;
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "forty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninety":
                return 90;
            default:
                return 0;
        }
    }
}
