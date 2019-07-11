package com.jiajia.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * jdk8��ʱ�������
 */
public class TestTime {
    /**
     * localDate() localTime() localDateTime()
     *
     */
    @Test
    public void test(){
        // ��Ȼ ����  ��Ȼʱ��  ��ǰ����+ʱ��
        LocalDate localDate = LocalDate.now() ;
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("��ǰ����:" + localDate + "\n��ǰʱ�䣺" + localTime + "\n��ǰ���ڼ�ʱ�� �� " + localDateTime);
        // .of() ָ���ض��� ʱ��
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,10,10,10,10);
        System.out.println("\nָ����ʱ���� : " + localDateTime1);
        //��ȡ�������
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println("\n��ȡ����ʱ���е����ԣ�" + "\n��" + localDateTime2.getYear() +"\n����" + localDateTime2.getMinute() + "\n ���µĵڼ���" + localDateTime2.getDayOfMonth());
        // �Զ���ʱ���ʽ
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println("��ʽ��ʱ�� �� " + format);
        // �����ַ���
        TemporalAccessor parse = dateTimeFormatter.parse(format);
        System.out.println("ת�����ʱ�� : "+ parse);



    }
}
