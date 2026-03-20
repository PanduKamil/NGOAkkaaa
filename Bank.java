import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.List;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Bank {
    private HashMap<String, Nasabah> mapNasabah;
    private static Bank instance;
    DecimalFormat kursIndonesia = new DecimalFormat("###,###.##");
    private NasabahDAO = new NasabahDAO();

    String pattern = "dd-MM-yyyy HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    private Bank(){
        this.mapNasabah = new HashMap<>();
    }
    public static Bank getInstance(){
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }
    public List<Nasabah> getTopNasabah(int limit){
        return mapNasabah.values().stream()
        .sorted((a, b) -> b.getSaldo().compareTo(a.getSaldo()))
        .limit(limit)
        .collect(Collectors.toList());
    } 

    public void tambahNasabah(Nasabah akun) {
        nasabahDAO.tambahNasabah(akun);
    }
    public Nasabah cariNasabah(String noRek) {
        return mapNasabah.get(noRek);
    }
    public Collection<Nasabah> getSemuaNasabah(){
        return mapNasabah.values();
    }
}
