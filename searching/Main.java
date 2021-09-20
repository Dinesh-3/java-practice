package searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int[] numbers = getNumbers("unsortedNumbers");
//        System.out.println("numbers = " + Arrays.toString(numbers));
        long linearStart = System.currentTimeMillis();
        int index = LinearSearch.index(numbers, numbers[numbers.length -1] );
        long linearEnd = System.currentTimeMillis();
        System.out.println("LINEAR Time Taken: " + (linearEnd-linearStart));
        System.out.println("index = " + index);

        System.out.println();

        int[] sortedNumbers = getNumbers("sortedNumbers");
        long binaryStart = System.currentTimeMillis();
        int binaryIndex = BinarySearch.search(sortedNumbers, sortedNumbers[sortedNumbers.length - 1]);
        long binaryEnd = System.currentTimeMillis();
        System.out.println("BINARY Time Taken: " + (binaryEnd-binaryStart));
        System.out.println("index = " + binaryIndex);
    }

    private static int[] getNumbers(String fileName) {
        try(
                BufferedReader reader = new BufferedReader(new FileReader("/home/dinesh/Downloads/Java Practice/searching/"+fileName+".csv"));
        ) {
            String line = reader.readLine();
            String[] numbers = line.split(", ");
            int[] list = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                String number = numbers[i];
                int parseInt = Integer.parseInt(number);
                list[i] = parseInt;
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[]{};
    }

    private static int[] getSortedNumbers() {
        return new int[]{
                100, 101, 105, 106, 107, 110, 111, 112, 113, 116, 120, 121, 122, 124, 125, 128, 129, 130, 133, 134, 136,
                140, 143, 144, 145, 146, 147, 149, 150, 152, 157, 158, 161, 162, 165, 168, 171, 173, 174, 177, 179, 181,
                182, 185, 188, 191, 192, 193, 194, 195, 196, 198, 199, 202, 203, 205, 206, 208, 209, 210, 211, 215, 217,
                219, 222, 224, 226, 228, 231, 232, 234, 236, 238, 239, 240, 242, 246, 247, 248, 250, 253, 256, 257, 259,
                265, 266, 267, 269, 270, 271, 272, 275, 277, 279, 280, 281, 282, 284, 285, 286, 287, 289, 290, 293, 294,
                295, 297, 298, 307, 308, 309, 310, 312, 314, 317, 318, 319, 321, 322, 323, 324, 326, 329, 330, 333, 334,
                335, 336, 337, 339, 340, 341, 342, 343, 346, 347, 348, 349, 351, 354, 355, 356, 357, 361, 362, 364, 365,
                367, 368, 369, 371, 374, 376, 378, 379, 380, 381, 384, 385, 386, 387, 388, 389, 391, 393, 394, 395, 396,
                397, 398, 400, 401, 403, 406, 407, 408, 409, 412, 413, 414, 415, 416, 418, 419, 420, 422, 423, 425, 426,
                430, 431, 432, 433, 434, 435, 436, 437, 438, 441, 442, 443, 444, 445, 446, 451, 452, 454, 458, 461, 463,
                469, 470, 471, 473, 478, 479, 480, 481, 482, 484, 486, 491, 492, 495, 497, 500, 501, 503, 504, 505, 506,
                507, 510, 513, 515, 516, 517, 519, 521, 525, 528, 529, 530, 533, 535, 537, 539, 541, 542, 543, 544, 549,
                550, 553, 555, 560, 561, 562, 563, 564, 565, 567, 569, 570, 571, 572, 575, 578, 579, 581, 582, 583, 587,
                588, 589, 590, 591, 592, 593, 594, 595, 596, 599, 601, 603, 605, 606, 609, 610, 611, 613, 614, 619, 620,
                624, 626, 628, 629, 630, 631, 632, 634, 635, 638, 639, 644, 646, 648, 651, 653, 654, 659, 666, 668, 669,
                670, 671, 672, 675, 677, 678, 680, 681, 682, 683, 684, 686, 687, 688, 692, 693, 695, 696, 697, 700, 701,
                706, 707, 708, 709, 710, 712, 713, 714, 717, 719, 720, 721, 723, 725, 728, 730, 734, 736, 737, 738, 740,
                743, 748, 749, 751, 752, 754, 755, 758, 761, 762, 765, 766, 769, 772, 773, 774, 775, 777, 779, 781, 783,
                785, 787, 788, 790, 791, 795, 797, 798, 800, 801, 809, 811, 814, 815, 817, 818, 823, 831, 832, 835, 836,
                838, 839, 840, 842, 843, 844, 845, 846, 847, 849, 850, 854, 857, 859, 862, 864, 866, 867, 870, 871, 872,
                873, 874, 876, 877, 878, 880, 881, 882, 883, 884, 885, 887, 890, 893, 894, 897, 898, 900, 901, 902, 904,
                908, 910, 912, 913, 914, 916, 917, 919, 920, 921, 923, 924, 925, 927, 928, 929, 930, 931, 935, 937, 939,
                940, 941, 942, 945, 946, 947, 948, 949, 951, 952, 953, 954, 955, 957, 958, 959, 960, 961, 962, 964, 965,
                967, 968, 969, 971, 973, 974, 978, 979, 984, 986, 987, 989, 992, 993, 994, 996, 998
        };
    }
}
