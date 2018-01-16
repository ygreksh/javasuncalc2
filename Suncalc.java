import java.util.Calendar;
import java.util.GregorianCalendar;

public class Suncalc {
    public static void main(String[] arg){
        double Lon = 41.43147; //долгота
        double Lat = 43.64986;
        int Year = 2009;
        int Mon = 6;
        int Day = 19;
        double UT = 14.0;

        System.out.println("Lon = " + Lon);
        System.out.println("Lat = " + Lat);
        System.out.println("Date = " + Year + "." + Mon + "." + Day);
        //System.out.println("UT = " + UT);

        // 1.Вычисление модифицированной юлианской даты на начало суток
        /*
        var1 =   20090619
        var2 =   487
        var3 =   54281
        MD =    55001
        */
        //System.out.println("1.Вычисление модифицированной юлианской даты на начало суток");
        Calendar testDate = new GregorianCalendar();
        testDate.set(Calendar.YEAR, Year);
        testDate.set(Calendar.MONTH, Mon-1);
        testDate.set(Calendar.DAY_OF_MONTH, Day);
        testDate.set(Calendar.HOUR_OF_DAY, (int) UT);
        testDate.set(Calendar.MINUTE, 0);
        testDate.set(Calendar.SECOND, 0);

        AstroCalc.getSunPosition2(Lat, Lon, testDate);
        //System.out.println("MD = " + AstroCalc.ModD);

        // 2. Вычисление местного звездного времени
        /*
        Входные параметры: MD = 55001, UT = 14.0
        T0 =   9.46338124572211E-02
        S0 = 841764.178338331
        Nsec =  50400
        NsecS =  50537.9906264939
        SG =  117.925704020104
        ST = 159.357174020104
        */

        // 3. Вычисление эклиптических координат Солнца
        /*
        Входные параметры: MD = 55001, UT = 14.0
        T0=    9.46338124572211E-02
        M =   164.830326338125
        L0=   3687.92528576318
        L =   88.4161785572869 ' приведение угла в диапазон 0-360 градусов
        X =    2.76393789023711E-02
        Y =    0.999617959389432
        Z =    0
        */

        // 4. Координаты Cолнца в прямоугольной экваториальной системе координат
        /*
        X' =   2.76393789023711E-02
        Y' =   0.917131616862311
        Z' =    0.397625026985744
        */

        // 5.Экваториальные геоцентрические координаты Солнца
        /*
        Ra = 88.2738131051079            5h 53m  5.715145 sec
        Dec = 23.4297911659417           + 23g 25m 47.2482 sec
        */

        // 6.Азимутальные координаты Солнца
        /*
        Th =   71.0833609149958
        Az =  95.4220991915847
        H =  29.3205618652633
        */
    }
}
