package Subject;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class ProMain {
    public void createSubject(){
        //Math
        Subject subject1 = new Subject("01417111","Calculus I",3,false,3);
        Subject subject2 = new Subject("01417112","Calculus II",3,false,4,new String[] {"01417111"});
        Subject subject3 = new Subject("01417322","Principles of Statics",3,false,3,new String[] {"01417112"});
        Subject subject4 = new Subject("01417322","Introductory Linear Algebra",3,false,2,new String[] {"01417112"});

        //Major
        Subject subject5 = new Subject("01418114","Introduction to Computer Science",2,false,2);
        Subject subject6 = new Subject("01418112","Fundamental Programming Concepts",3,false,3,new String[] {"01418114"});
        Subject subject7 = new Subject("01418131","Digital Computer Logic",3,false,2);
        Subject subject8 = new Subject("01418113","Computer Programming",3,false,4,new String[] {"01418112"});
        Subject subject9 = new Subject("01418132","Fundamentals of Computing",4,false,3);
        Subject subject10 = new Subject("01418211","Software Construction",3,false,4,new String[] {"01417113"});
        Subject subject11 = new Subject("01418231","Data Structures",3,false,3,new String[] {"01418113"});
        Subject subject12 = new Subject("01418221","Fundamentals of Database Systems",3,false,3,new String[] {"01418113"});
        Subject subject13 = new Subject("01418232","Algorithm Design and Analysis",3,false,3,new String[] {"01418132","01418231"});
        Subject subject14 = new Subject("01418233","Assembly Language and Computer Architecture",4,false,4,new String[] {"01418113","01418131"});
        Subject subject15 = new Subject("01418321","System Analysis and Design",3,false,3,new String[] {"01418211","01418221"});
        Subject subject16 = new Subject("01418331","Operating Systems",4,false,3,new String[] {"01418233"});
        Subject subject17 = new Subject("01418341","Intellectual Property for Software and Digital Contents",3,false,3);
        Subject subject18 = new Subject("01418497","Seminar",3,false,3,new String[] {"01418221","01418232","01418233"});
        Subject subject19 = new Subject("01418332","Information System Security",3,false,3,new String[] {"01418331"});
        Subject subject20 = new Subject("01418333","Automata Theory",2,false,3,new String[] {"01418132"});
        Subject subject21 = new Subject("01418334","Compiler Techniques",2,false,3,new String[] {"01418333"});
        Subject subject22 = new Subject("01418351","Computer Communications and Protocols",3,false,3,new String[] {"01418331"});
        Subject subject23 = new Subject("01418390","Cooperative Education Preparation",1,false,2,new String[] {"01418390"});
        Subject subject24 = new Subject("01418490","Cooperative Education",6,false,4,new String[] {"01418390"});
        Subject subject25 = new Subject("01418499","Computer Science Project",3,false,4,new String[] {"01418321"});

        //วิชาเลือก
        Subject subject110 = new Subject("01418235","Unix Operating System & Shell Programming",3,false,3);
        Subject subject111 = new Subject("01418382","Computer Graphics Working Environment",3,false,3);
        Subject subject112 = new Subject("01418462","Theory of Artificial Intelligence",3,false,3);
        Subject subject113 = new Subject("01418325","Information Quality Management",3,false,3);
        Subject subject114 = new Subject("01418346","Mobile Application Design & Development",3,false,3);

        //หมวดศึกษาทั่วไป
        //สาระอยู่ดีมีสุข
        Subject subject26 = new Subject("01175111","Track and Field for Health",1,false,1);
        Subject subject27 = new Subject("01175112","Badminton for Health",1,false,1);
        Subject subject28 = new Subject("01175113","Tennis for Health",1,false,1);
        Subject subject29 = new Subject("01175114","Table Tennis for Health",1,false,1);
        Subject subject30 = new Subject("01175115","Meditation with Shooting for Health",1,false,1);
        Subject subject31 = new Subject("01175117","Meditation with Archery for Health",1,false,1);
        Subject subject32 = new Subject("01175121","Basketball for Health",1,false,1);
        Subject subject33 = new Subject("01175122","Soccer for Health",1,false,1);
        Subject subject34 = new Subject("01175123","Volleyball for Health",1,false,1);
        Subject subject35 = new Subject("01175124","Handball for Health",1,false,1);
        Subject subject36 = new Subject("01175125","Softball for Health",1,false,1);
        Subject subject37 = new Subject("01175126","Takraw for Health",1,false,1);
        Subject subject38 = new Subject("01175127","Hockey for Health",1,false,1);
        Subject subject39 = new Subject("01175128","Rugby Football for Health",1,false,1);
        Subject subject40 = new Subject("01175129","Futsal for Health",1,false,1);
        Subject subject41 = new Subject("01175131","Swimming for Health",1,false,1);
        Subject subject42 = new Subject("01175133","Diving",1,false,1);
        Subject subject43 = new Subject("01175134","Water Polo",1,false,1);
        Subject subject44 = new Subject("01175141","Aerobic Dance for Health",1,false,1);
        Subject subject45 = new Subject("01175142","Folk Dance by Local Culture for Health",1,false,1);
        Subject subject46 = new Subject("01175143","Social Dance for Health",1,false,1);
        Subject subject47 = new Subject("01175144","Thai Classical Dance for Health",1,false,1);
        Subject subject48 = new Subject("01175151","Martial Art with Thai Sword",1,false,1);
        Subject subject49 = new Subject("01175152","Martial Art with Thai Fencing",1,false,1);
        Subject subject50 = new Subject("01175153","Martial Art with Thai Boxing",1,false,1);
        Subject subject51 = new Subject("01175154","Martial Art with Sword",1,false,1);
        Subject subject52 = new Subject("01175155","Martial Art with Judo",1,false,1);
        Subject subject53 = new Subject("01175156","Martial Art with Aikido",1,false,1);
        Subject subject54 = new Subject("01175157","Martial Art with Krabi-Krabong",1,false,1);
        Subject subject55 = new Subject("01175159","Martial Art with Karate",1,false,1);
        Subject subject56 = new Subject("01175161","Brain Training with Playing Bridge",1,false,1);
        Subject subject57 = new Subject("01175162","Bowling for Health",1,false,1);
        Subject subject58 = new Subject("01175163","Golf for Health",1,false,1);
        Subject subject59 = new Subject("01175164","Cycling for Health",1,false,1);
        Subject subject60 = new Subject("01175165","Weight Training for Health",1,false,1);
        Subject subject61 = new Subject("01175166","Martial Art with Taekwondo",1,false,1);
        Subject subject62 = new Subject("01175168","Jogging for Health",1,false,1);
        Subject subject63 = new Subject("01175169","Exercise for developing Holistic Health",2,false,1);

        Subject subject64 = new Subject("01173151","AIDS Education",2,false,1);
        Subject subject65 = new Subject("01174231","Introduction to Recreation",2,false,1);
        Subject subject66 = new Subject("01459101","Psychology for Modern Life",3,false,2);
        Subject subject67 = new Subject("01999011","Food for Mankind",3,false,2);
        Subject subject68 = new Subject("01999033","Arts of Living",3,false,2);
        Subject subject69 = new Subject("01999213","Environment, Technology and Life",3,false,2);

        //ศาสตร์แห่งผู้ประกอบการ
        Subject subject70 = new Subject("01999041","Economics for Better Living",3,false,3);
        Subject subject71 = new Subject("01999043","Creative for Value Management",3,false,2);
        Subject subject72 = new Subject("01005101","Modern Agriculture Technology",3,false,2);

        //กลุ่มสาระพลเมืองไทยและพลเมืองโลก
        Subject subject73 = new Subject("01999111","Knowledge of the Land",2,false,2);
        Subject subject74 = new Subject("02999144","Life Skills for Undergraduate Student",1,false,1);
        Subject subject75 = new Subject("01015202","Thai Lives Agriculture",3,false,2);
        Subject subject76 = new Subject("01390102","Creative Tourism",3,false,2);
        Subject subject77 = new Subject("01455101","World Politics in Daily Life",3,false,2);
        Subject subject78 = new Subject("01999031","The Heritage of World Civilizations",3,false,2);
        Subject subject79 = new Subject("01999141","Man and Society",3,false,3);

        //กลุ่มสาระภาษากับการสื่อสาร
        Subject subject80 = new Subject("01999021","Thai Language for Communication",3,false,2);

        Subject subject81 = new Subject("01355111","Foundation English I",0,false,1);
        Subject subject82 = new Subject("01355112","Foundation English II",3,false,2,new String[] {"01355111"});
        Subject subject83 = new Subject("01355113","Foundation English III",3,false,2,new String[] {"01355112"});
        Subject subject84 = new Subject("01355201","Fundamental English Reading",3,false,3,new String[] {"01355113"});
        Subject subject85 = new Subject("01355202","Fundamental English Writing",3,false,3,new String[] {"01355113"});
        Subject subject86 = new Subject("01355203","Fundamental English Structure",3,false,4,new String[] {"01355113"});
        Subject subject87 = new Subject("01355204","Fundamental English Listening-Speaking",3,false,3,new String[] {"01355113"});
        Subject subject88 = new Subject("01355205","Reading for Mass Communication in English",3,false,3,new String[] {"01355113"});
        Subject subject89 = new Subject("01355206","Technical English",3,false,3,new String[] {"01355113"});
        Subject subject90 = new Subject("01355207","English Correspondence",3,false,3,new String[] {"01355113"});
        Subject subject91 = new Subject("01355208","English through Songs",3,false,3,new String[] {"01355113"});
        Subject subject92 = new Subject("01355209","Communicative English for Careers",3,false,3,new String[] {"01355113"});
        Subject subject93 = new Subject("01355302","Report Writing in English",3,false,3,new String[] {"01355113"});
        Subject subject94 = new Subject("01355303","English for Employment",3,false,3,new String[] {"01355113"});

        Subject subject95 = new Subject("01371111","Information Media",1,false,1);
        Subject subject96 = new Subject("01999013","New Age Information Management in Everyday Life",3,false,1);

        //กลุ่มสาระสุนทรียศาสตร์
        Subject subject97 = new Subject("01255101","Man and Sea",3,false,1);
        Subject subject98 = new Subject("01376101","Literature and Life",3,false,1);
        Subject subject99 = new Subject("01999034","Art Perception",3,false,1);
        Subject subject100 = new Subject("01999035","Music Culture in Life",3,false,1);

        //วิชาของคณะวิทยาศาสตร์
        Subject subject101 = new Subject("01401201","Plants, Man and Environment",3,false,2);
        Subject subject102 = new Subject("01404101","General Science",3,false,2);
        Subject subject103 = new Subject("01420101","Physics in Everyday life",2,false,3);
        Subject subject104 = new Subject("01420102","Basic Theater Physics",3,false,2);
        Subject subject105 = new Subject("01420201","Gems and Jewelry",3,false,2);
        Subject subject106 = new Subject("01421211","Radiation, Life and Environment",3,false,2);
        Subject subject107 = new Subject("01422101","Elementary Applied Statics",3,false,3);
        Subject subject108 = new Subject("01424201","Life and Environment Science",3,false,2);
        Subject subject109 = new Subject("01402101","Beauty Products Literacy",3,false,2);
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
        subjects.add(subject5);
        subjects.add(subject6);
        subjects.add(subject7);
        subjects.add(subject8);
        subjects.add(subject9);
        subjects.add(subject10);

        subjects.add(subject11);
        subjects.add(subject12);
        subjects.add(subject13);
        subjects.add(subject14);
        subjects.add(subject15);
        subjects.add(subject16);
        subjects.add(subject17);
        subjects.add(subject18);
        subjects.add(subject19);
        subjects.add(subject20);

        subjects.add(subject21);
        subjects.add(subject22);
        subjects.add(subject23);
        subjects.add(subject24);
        subjects.add(subject25);
        subjects.add(subject26);
        subjects.add(subject27);
        subjects.add(subject28);
        subjects.add(subject29);
        subjects.add(subject30);

        subjects.add(subject31);
        subjects.add(subject32);
        subjects.add(subject33);
        subjects.add(subject34);
        subjects.add(subject35);
        subjects.add(subject36);
        subjects.add(subject37);
        subjects.add(subject38);
        subjects.add(subject39);
        subjects.add(subject40);

        subjects.add(subject41);
        subjects.add(subject42);
        subjects.add(subject43);
        subjects.add(subject44);
        subjects.add(subject45);
        subjects.add(subject46);
        subjects.add(subject47);
        subjects.add(subject48);
        subjects.add(subject49);
        subjects.add(subject50);

        subjects.add(subject51);
        subjects.add(subject52);
        subjects.add(subject53);
        subjects.add(subject54);
        subjects.add(subject55);
        subjects.add(subject56);
        subjects.add(subject57);
        subjects.add(subject58);
        subjects.add(subject59);
        subjects.add(subject60);

        subjects.add(subject61);
        subjects.add(subject62);
        subjects.add(subject63);
        subjects.add(subject64);
        subjects.add(subject65);
        subjects.add(subject66);
        subjects.add(subject67);
        subjects.add(subject68);
        subjects.add(subject69);
        subjects.add(subject70);

        subjects.add(subject71);
        subjects.add(subject72);
        subjects.add(subject73);
        subjects.add(subject74);
        subjects.add(subject75);
        subjects.add(subject76);
        subjects.add(subject77);
        subjects.add(subject78);
        subjects.add(subject79);
        subjects.add(subject80);

        subjects.add(subject81);
        subjects.add(subject82);
        subjects.add(subject83);
        subjects.add(subject84);
        subjects.add(subject85);
        subjects.add(subject86);
        subjects.add(subject87);
        subjects.add(subject88);
        subjects.add(subject89);
        subjects.add(subject90);

        subjects.add(subject91);
        subjects.add(subject92);
        subjects.add(subject93);
        subjects.add(subject94);
        subjects.add(subject95);
        subjects.add(subject96);
        subjects.add(subject97);
        subjects.add(subject98);
        subjects.add(subject99);
        subjects.add(subject100);

        subjects.add(subject101);
        subjects.add(subject102);
        subjects.add(subject103);
        subjects.add(subject104);
        subjects.add(subject105);
        subjects.add(subject106);
        subjects.add(subject107);
        subjects.add(subject108);
        subjects.add(subject109);
        subjects.add(subject110);

        subjects.add(subject111);
        subjects.add(subject112);
        subjects.add(subject113);
        subjects.add(subject114);

        JsonControlData jdata = new JsonControlData();
        jdata.writeToJson(subjects);

    }

    public static void main(String[] args) {
        ProMain proMain = new ProMain();
        proMain.createSubject();
        JsonControlData jdata = new JsonControlData();
        for (Subject x: jdata.readFromJson()
             ) {
            System.out.println(x);
        }
    }
}
