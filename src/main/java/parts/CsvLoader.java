package parts;
import data.CustomerList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CsvLoader {
    public CsvLoader(){
        ArrayList<CustomerList> catchList = new ArrayList<>();
        Path pathCsv = Paths.get("src/main/resources/csv/aaa.csv");
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(pathCsv)),"UTF-8"));
            String line;
            if ((line = br.readLine()) != null) {
                // 先頭行除外処理
            }
            while((line = br.readLine()) != null){
                String[] factor = line.split(",",-1);
                if (factor.length == 12) {
                    String empcode = factor[0];
                    String belongcode = factor[1];
                    String name = factor[2];
                    String namekana = factor[3];
                    String birthday = factor[4];
                    String sex = factor[5];
                    String address = factor[6];
                    String tel_number = factor[7];
                    String inst_id = factor[8];
                    String inst_dt = factor[9];
                    String updt_id = factor[10];
                    String updt_dt = factor[11];
                    // catchListオブジェクトを作成しリストに追加
                    catchList.add(new CustomerList(empcode, belongcode, name, namekana, birthday, sex, address, tel_number, inst_id, inst_dt, updt_id, updt_dt));

                } else {
                    System.out.println("データの形式が正しくありません: " + line);
                }
            }
        }catch (IOException e) {
            System.out.println("CSVとれてないです");
        }
        System.out.println("1.年齢が30歳～35歳までの男性の名前をプロンプト上で表示させる");
        for (CustomerList CustomerList : catchList) {
            CustomerList.searchList();
        }
    }
}
