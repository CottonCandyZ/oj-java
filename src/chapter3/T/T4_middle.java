package chapter3.T;
// https://www.nowcoder.com/practice/100a4376cafc439b86f5f8791fb461f3?tpId=63&tqId=29564&tPage=1&ru=%2Fkaoyan%2Fretest%2F9001&qru=%2Fta%2Fzju-kaoyan%2Fquestion-ranking&tab=answerKey
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
// 总结
// 比较 Double 时采用 Double.compare()
// 考虑到 0 / 0 是 NaN 的情况
// 另外，题目的要求似乎只要按照选出的排名即可
// 另外这题虽然出现在排序的章节，但其实不需要排序。
public class T4_middle {
    private static class Country {
        public Country(int id, int totalGMedals, int totalMedals, int population) {
            this.id = id;
            this.totalGMedals = totalGMedals;
            this.totalMedals = totalMedals;
            this.population = population;
            // 特殊处理 0
            this.gMProportion = totalGMedals == 0 ? 0: (double) totalGMedals / population;
            this.mProportion = totalMedals == 0 ? 0:(double) totalMedals / population;
        }
        int id;
        int totalGMedals;
        int totalMedals;
        int population;
        double gMProportion;
        double mProportion;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] str;
        while ((line = rd.readLine()) != null) {
            int num = Integer.parseInt(line.split(" ")[0]);
            int rankNum = Integer.parseInt(line.split(" ")[1]);
            Country[] countries = new Country[num];
            int i = 0;
            while (num-- > 0) {
                line = rd.readLine();
                str = line.split(" ");
                countries[i++] = new Country(
                        i - 1,
                        Integer.parseInt(str[0]),
                        Integer.parseInt(str[1]),
                        Integer.parseInt(str[2])
                );
            }
            int[] rankCountryIndex = new int[rankNum];
            str = rd.readLine().split(" ");
            i = 0;
            for (String s : str) {
                rankCountryIndex[i++] = Integer.parseInt(s);
            }

            int len = countries.length;
            // rank 数组用来存储排序后每一组的序
            // 其中 列号 对应国家，行号 对应排序方法
            // 存在格子中的是排名
            int[][] ranked = new int[4][len];

            // 四种排序
            Arrays.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return  o2.totalGMedals - o1.totalGMedals;
                }
            });
            ranked[0][countries[0].id] = 1;
            for (int j = 1; j < len; j++) {
                if (countries[j - 1].totalGMedals == countries[j].totalGMedals) {
                    ranked[0][countries[j].id] = ranked[0][countries[j - 1].id];
                } else {
                    ranked[0][countries[j].id] = j + 1;
                }
            }

            Arrays.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return  o2.totalMedals - o1.totalMedals;
                }
            });
            ranked[1][countries[0].id] = 1;
            for (int j = 1; j < len; j++) {
                if (countries[j - 1].totalMedals == countries[j].totalMedals) {
                    ranked[1][countries[j].id] = ranked[1][countries[j - 1].id];
                } else {
                    ranked[1][countries[j].id] = j + 1;
                }
            }
            Arrays.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return Double.compare(o2.gMProportion, o1.gMProportion);
                }
            });
            ranked[2][countries[0].id] = 1;
            for (int j = 1; j < len; j++) {
                if (countries[j - 1].gMProportion == countries[j].gMProportion) {
                    ranked[2][countries[j].id] = ranked[2][countries[j - 1].id];
                } else {
                    ranked[2][countries[j].id] = j + 1;
                }
            }
            Arrays.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return  Double.compare(o2.mProportion, o1.mProportion);
                }
            });
            ranked[3][countries[0].id] = 1;
            for (int j = 1; j < len; j++) {
                if (countries[j - 1].mProportion == countries[j].mProportion) {
                    ranked[3][countries[j].id] = ranked[3][countries[j - 1].id];
                } else {
                    ranked[3][countries[j].id] = j + 1;
                }
            }


            for (int countryIndex : rankCountryIndex) {
                int min = ranked[0][countryIndex];
                int way = 0;
                for (int j = 1; j < 4; j++) {
                    if (min > ranked[j][countryIndex]) {
                        min = ranked[j][countryIndex];
                        way = j;
                    }
                }
                System.out.println(min + ":" + (way + 1));
            }
            System.out.println();
        }
    }
}
