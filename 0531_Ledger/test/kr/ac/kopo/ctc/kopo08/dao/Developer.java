package kr.ac.kopo.ctc.kopo08.dao;

public class Developer {
    
    public String name;
    public int career;
    public Category type;
     
    public static void main(String[] args){
     
        for(Category type : Category.values()){
            System.out.println(type.name() + " " + type.getName());
        }
    }
 
}
 
enum Category {
 
    A("식비"),
    B("주거/통신"),
    C("생활용품"),
    D("의복/미용"),
    E("건강/문화"),
    F("교육/육아"),
    G("교통/차량"),
    H("경조사/회비"),
    I("세금/이자"),
    J("용돈/기타"),
    K("카드대금"),
    L("저축/보험"),
    M("이체/대체");
     
    final private String name;
     
    public String getName() {
        return name;
    }
 
    private Category(String name){
        this.name = name;
    }
}