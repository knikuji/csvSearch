
package data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerList {
    private String empcode;
    private String belongcode;
    private String name;
    private String namekana;
    private String birthday;
    private String sex;
    private String address;
    private String tel_number;
    private String inst_id;
    private String inst_dt;
    private String updt_id;
    private String updt_dt;

    public CustomerList(String empcode, String belongcode, String name, String namekana, String birthday, String sex, String address, String tel_number, String inst_id, String inst_dt, String updt_id, String updt_dt) {
        this.empcode = empcode;
        this.belongcode = belongcode;
        this.name = name;
        this.namekana = namekana;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.tel_number = tel_number;
        this.inst_id = inst_id;
        this.inst_dt = inst_dt;
        this.updt_id = updt_id;
        this.updt_dt = updt_dt;
    }

    //ゲッターメソッド
    public String getEmpcode() {return empcode;}
    public String getBelongcode() {return belongcode;}
    public String getName() {return name;}
    public String getNamekana() {return namekana;}
    public String getBirthday() {return birthday;}
    public String getSex() {return sex;}
    public String getAddress() {return address;}
    public String getTel_number() {return tel_number;}
    public String getInst_id() {return inst_id;}
    public String getInst_dt() {return inst_dt;}
    public String getUpdt_id() {return updt_id;}
    public String getUpdt_dt() {return updt_dt;}

    public void searchList() {
        // 生年月日のフォーマットに合わせてパーサーを作成
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            // 生年月日をLocalDateに変換
            LocalDate birthDate = LocalDate.parse(birthday, dateFormatter);
            // 現在の日付を取得
            LocalDate currentDate = LocalDate.now();
            // 年齢を計算
            int age = Period.between(birthDate, currentDate).getYears();
            // 性別が"1"で、年齢が30歳以上35歳以下の場合
            if ("1".equals(sex) && age >= 30 && age <= 35) {
                System.out.println("-------------------------");
                System.out.println("対象ユーザー名前: " + name);
                //チェックのため性別判定記載（振り分け的に不要認識）
                String sexSet = sex.equals("1")?"男性":"女性";
                System.out.println("性別: " +sexSet);
                System.out.println("年齢: " + age + "歳");
                System.out.println("-------------------------");
                System.out.println("");
            }else{
                System.out.println("デバッグ非対象: " + name);
                String sexSet = sex.equals("1")?"男性":"女性";
                System.out.println("性別: " +sexSet);
                System.out.println("年齢: " + age + "歳");
                System.out.println("");
            }
        } catch (DateTimeParseException e) {
            System.out.println("生年月日の形式が不正です: " + birthday);
        }
    }

}
