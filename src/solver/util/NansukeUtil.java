package solver.util;

import java.util.ArrayList;

public class NansukeUtil {
    private static int board0[][] = {
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 0}
    };
    private static String listNumber0[] = {"223", "235", "65"};
    private static int board1[][] = {
            {1, 0, 1, 0},
            {1, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 0, 0}

    };
    private static String listNumber1[] = {"12", "2345", "146", "67", "43", "57"};
    private static int board2[][] = {
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 1}

    };
    private static String listNumber2[] = {"1234", "23456", "245", "57", "47698", "97", "79", "24567", "4579", "56", "82"};

    private static int board3[][] = {
            {1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 0},
            {1, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1}
    };
    private static String listNumber3[] = {"8765", "3214", "8761", "31", "199", "6543", "42", "79", "233", "888", "48", "89",
            "6412", "679", "914", "579", "5346", "19", "22249", "781", "89148", "972", "93861", "689", "84452", "57", "34", "66942549", "315", "76", "43", "69", "133387", "18", "41", "399891"};

    private static int board4[][] = {
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}
    };
    private static String listNumber4[] = {"111", "122", "211", "212", "55755", "55775", "56656", "56755", "56765", "56775", "56785",
            "56787", "56789", "75855", "77856", "77858", "77876", "77879", "95655", "95657", "96679", "96777", "97698", "98677", "156789",
            "256789", "556677", "586757", "656585", "667768", "668688", "678688", "679876", "686869", "777777", "857586", "858799",
            "866967", "887992", "888755", "957957", "969897", "976668", "977572"};
    private static int board5[][] = {
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0},
            {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private static String listNumber5[] = {"352148", "476234", "453823197", "36", "6146", "54327946", "43", "419", "9452", "2357", "9537731", "3456", "5421", "83648", "87789", "329571", "34", "32185", "347657", "79813589", "3241"
            , "492853", "63", "324795", "158", "73159286", "823176985", "72", "6781", "357", "737864293", "851", "23467", "89", "851", "437", "35", "45", "364973", "356", "12834", "39"};
    private static int board6[][] = {
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}
    };


    private static String listNumber6[] = {
            "1234", "78856", "433", "9436", "798", "412654", "44", "956", "962", "2855", "754", "13499455572", "65322", "89", "345", "82", "52435", "6855391", "49696", "6188", "7999",
            "34567899", "8675", "29", "324915", "4756", "1467", "39", "9997371", "96152", "7779", "235", "7444", "1336", "93135", "79612", "1669", "2435", "74", "1111", "6986435",
            "76766712", "944436", "59",

            "947654321", "7777", "14455", "949494946", "23", "43565", "6646", "369", "22963714116", "5124672", "216", "763", "84321", "17",
            "79", "4556999", "3111", "88999", "191", "736", "69", "68", "597666", "54243888", "97", "999", "61", "545", "64999", "84", "225557777", "3264",
            "4685", "3955321444", "3557899", "6733333", "34522196", "155556"
    };

    public static Nansuke[] arrNansukeQuestions = {new Nansuke(new Matrix(board1), listNumber1),
            new Nansuke(new Matrix(board2), listNumber2), new Nansuke(new Matrix(board3), listNumber3), new Nansuke(new Matrix(board4), listNumber4), new Nansuke(new Matrix(board6), listNumber6)};
}
