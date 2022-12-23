package com.example.idnp_v3;



import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.idnp_v3.entidades.AfiliadoEntidad;

import java.util.ArrayList;


public class ManagerBD extends SQLiteOpenHelper {



    private static  final String NAME_BD = "RecyclartDB.db";
    private static  final int VERSION_BD = 3;
    private static final String SCRIPT = ("CREATE TABLE " +
            "`afiliado` (" + "  `afiId` int NOT NULL," + "  `afiUsr` varchar(45) DEFAULT NULL," + "  `afiCon` varchar(45) DEFAULT NULL," + "  `afiNom` varchar(45) DEFAULT NULL," + "  `afiProp` varchar(45) DEFAULT NULL," + "  `afiDir` varchar(45) DEFAULT NULL," + "  `afiWeb` varchar(45) DEFAULT NULL," + "  PRIMARY KEY (`afiId`)" + ")" +
            "");

    public ManagerBD(Context context) {
        super(context, NAME_BD, null, VERSION_BD);
        SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("createdatabase","EjecucionCreate");
        sqLiteDatabase.execSQL("PRAGMA foreign_keys = false;");
        sqLiteDatabase.execSQL("CREATE TABLE \"afiliado\" (\n" +
                "  \"afiId\" integer NOT NULL,\n" +
                "  \"afiUsr\" text(45),\n" +
                "  \"afiCon\" text(45),\n" +
                "  \"afiNom\" text(45),\n" +
                "  \"afiProp\" text(45),\n" +
                "  \"afiDirLat\" text(45),\n"+
                "  \"afiDirLon\" text(45),\n"+
                "  \"afiDir\" text(45),\n" +
                "  \"afiWeb\" text(45),\n" +
                "  PRIMARY KEY (\"afiId\")\n" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE \"canje\" (\n" +
                "  \"canId\" integer NOT NULL,\n" +
                "  \"afiId\" integer,\n" +
                "  \"tipoCan\" integer,\n" +
                "  \"canNom\" text(45),\n" +
                "  \"canCant\" text(45),\n" +
                "  PRIMARY KEY (\"canId\"),\n" +
                "  CONSTRAINT \"fk_Canje_Afiliado1\" FOREIGN KEY (\"afiId\") REFERENCES \"afiliado\" (\"afiId\") ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT \"fk_Canje_TipoCanje1\" FOREIGN KEY (\"tipoCan\") REFERENCES \"tipocanje\" (\"tipoCanId\") ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE \"monitor\" (\n" +
                "  \"moniId\" integer NOT NULL,\n" +
                "  \"moniUsr\" text(45),\n" +
                "  \"moniCon\" text(45),\n" +
                "  \"moniNom\" text(45),\n" +
                "  \"moniApe\" text(45),\n" +
                "  PRIMARY KEY (\"moniId\")\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE \"plastico\" (\n" +
                "  \"plasId\" integer NOT NULL,\n" +
                "  \"tipoPlasId\" integer,\n" +
                "  \"plasDet\" text(45),\n" +
                "  PRIMARY KEY (\"plasId\"),\n" +
                "  CONSTRAINT \"fk_Plastico_TipoPlastico\" FOREIGN KEY (\"tipoPlasId\") REFERENCES \"tipoplastico\" (\"tipoPlasId\") ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE \"tipocanje\" (\n" +
                "  \"tipoCanId\" integer NOT NULL,\n" +
                "  \"tipoCanDet\" text(45),\n" +
                "  PRIMARY KEY (\"tipoCanId\")\n" +
                ");\n");
        sqLiteDatabase.execSQL("CREATE TABLE \"tipoplastico\" (\n" +
                "  \"tipoPlasId\" integer NOT NULL,\n" +
                "  \"tipoPlasDet\" text(45),\n" +
                "  PRIMARY KEY (\"tipoPlasId\")\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE \"usuario\" (\n" +
                "  \"usrId\" integer NOT NULL,\n" +
                "  \"usrUsr\" text(45),\n" +
                "  \"usrCon\" text(45),\n" +
                "  \"usrNom\" text(45),\n" +
                "  \"usrApe\" text(45),\n" +
                "  \"usrRecTotal\" integer,\n" +
                "  \"usrRecPuntos\" integer,\n" +
                "  PRIMARY KEY (\"usrId\")\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE \"usuariocanje\" (\n" +
                "  \"usrCanId\" integer NOT NULL,\n" +
                "  \"usrId\" integer,\n" +
                "  \"canId\" integer,\n" +
                "  \"usrCanFecha\" text,\n" +
                "  \"usrCanTotal\" integer,\n" +
                "  PRIMARY KEY (\"usrCanId\"),\n" +
                "  CONSTRAINT \"fk_usuarioCanje_Canje1\" FOREIGN KEY (\"canId\") REFERENCES \"canje\" (\"canId\") ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT \"fk_usuarioCanje_Usuario1\" FOREIGN KEY (\"usrId\") REFERENCES \"usuario\" (\"usrId\") ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE \"usuarioreciclaje\" (\n" +
                "  \"usrRecId\" integer NOT NULL,\n" +
                "  \"usrId\" integer,\n" +
                "  \"moniId\" integer,\n" +
                "  \"plasId\" integer,\n" +
                "  \"usrRecFecha\" text,\n" +
                "  \"usrRecTotal\" integer,\n" +
                "  PRIMARY KEY (\"usrRecId\"),\n" +
                "  CONSTRAINT \"fk_usuarioReciclaje_Monitor1\" FOREIGN KEY (\"moniId\") REFERENCES \"monitor\" (\"moniId\") ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT \"fk_usuarioReciclaje_Plastico1\" FOREIGN KEY (\"plasId\") REFERENCES \"plastico\" (\"plasId\") ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT \"fk_usuarioReciclaje_Usuario1\" FOREIGN KEY (\"usrId\") REFERENCES \"usuario\" (\"usrId\") ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ");");

        sqLiteDatabase.execSQL("INSERT INTO \"afiliado\" VALUES (1, 'accronos', '123', 'casacronos', 'Edgar Medina', -16.390219, -71.516281,'' ,'');");
        sqLiteDatabase.execSQL("INSERT INTO \"afiliado\" VALUES (2, 'adlucio', '123', 'donlucio', 'Francisco Vasquez', -16.393010, -71.518591, '','');");
        sqLiteDatabase.execSQL("INSERT INTO \"canje\" VALUES (1, 1, 2, 'Croquetas para perro', '4');");
        sqLiteDatabase.execSQL("INSERT INTO \"canje\" VALUES (2, 1, 2, 'Collar para perro', '12');");
        sqLiteDatabase.execSQL("INSERT INTO \"canje\" VALUES (3, 1, 2, 'Llavero', '3');");
        sqLiteDatabase.execSQL("INSERT INTO \"canje\" VALUES (4, 1, 2, 'Plato de comida', '15');");
        sqLiteDatabase.execSQL("INSERT INTO \"canje\" VALUES (5, 1, 1, 'Desparacitación', '18');");
        sqLiteDatabase.execSQL("INSERT INTO \"canje\" VALUES (6, 2, 1, 'Pulsera', '3');");
        sqLiteDatabase.execSQL("INSERT INTO \"monitor\" VALUES (1, 'mklinares', '123', 'Karoli', 'Linares Figueroa');\n");
        sqLiteDatabase.execSQL("INSERT INTO \"monitor\" VALUES (2, 'mfpanca', '123', 'Fernando Alberto', 'Panca Ihue');\n");
        sqLiteDatabase.execSQL("INSERT INTO \"plastico\" VALUES (11, 1, 'Botella de Bebida');");
        sqLiteDatabase.execSQL("INSERT INTO \"plastico\" VALUES (12, 1, 'Botella o Frasci de Comida');");
        sqLiteDatabase.execSQL("INSERT INTO \"plastico\" VALUES (21, 2, 'Cartones de Leche');");
        sqLiteDatabase.execSQL("INSERT INTO \"plastico\" VALUES (22, 2, 'Forros para caja de cereales');");
        sqLiteDatabase.execSQL("INSERT INTO \"tipocanje\" VALUES (1, 'Servicio');");
        sqLiteDatabase.execSQL("INSERT INTO \"tipocanje\" VALUES (2, 'Producto');");
        sqLiteDatabase.execSQL("INSERT INTO \"tipoplastico\" VALUES (1, 'PET o PETE');");
        sqLiteDatabase.execSQL("INSERT INTO \"tipoplastico\" VALUES (2, 'HDPE');");
        sqLiteDatabase.execSQL("INSERT INTO \"usuario\" VALUES (72006110, 'gcallo', '123', 'Gabriel', 'Callo Condori', 50, 36);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuariocanje\" VALUES (1, 72006110, 1, NULL, 4);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuariocanje\" VALUES (2, 72006110, 3, NULL, 3);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuariocanje\" VALUES (3, 72006110, 4, NULL, 3);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuariocanje\" VALUES (4, 72006110, 3, NULL, 3);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuarioreciclaje\" VALUES (1, 72006110, 1, 11, NULL, 6);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuarioreciclaje\" VALUES (2, 72006110, 1, 12, NULL, 12);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuarioreciclaje\" VALUES (3, 72006110, 2, 11, NULL, 14);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuarioreciclaje\" VALUES (4, 72006110, 1, 21, NULL, 8);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuarioreciclaje\" VALUES (5, 72006110, 2, 22, NULL, 6);");
        sqLiteDatabase.execSQL("INSERT INTO \"usuarioreciclaje\" VALUES (6, 72006110, 1, 12, NULL, 4);");

        sqLiteDatabase.execSQL("CREATE INDEX \"fk_Canje_Afiliado1_idx\"\n" +
                "ON \"canje\" (\n" +
                "  \"afiId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_Canje_TipoCanje1_idx\"\n" +
                "ON \"canje\" (\n" +
                "  \"tipoCan\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_Plastico_TipoPlastico_idx\"\n" +
                "ON \"plastico\" (\n" +
                "  \"tipoPlasId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_usuarioCanje_Canje1_idx\"\n" +
                "ON \"usuariocanje\" (\n" +
                "  \"canId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_usuarioCanje_Usuario1_idx\"\n" +
                "ON \"usuariocanje\" (\n" +
                "  \"usrId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_usuarioReciclaje_Monitor1_idx\"\n" +
                "ON \"usuarioreciclaje\" (\n" +
                "  \"moniId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_usuarioReciclaje_Plastico1_idx\"\n" +
                "ON \"usuarioreciclaje\" (\n" +
                "  \"plasId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE INDEX \"fk_usuarioReciclaje_Usuario1_idx\"\n" +
                "ON \"usuarioreciclaje\" (\n" +
                "  \"usrId\" ASC\n" +
                ");");
        sqLiteDatabase.execSQL("PRAGMA foreign_keys = true;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("createdatabase","EjecucionCreateUgrade");

    }

    public void agregarUsuario(String usrId, String usrUsr, String UsrCon,String UsrNom, String UsrApe){
        SQLiteDatabase bd = getWritableDatabase();

        if(bd != null){
            bd.execSQL("insert into usuario values('"+usrId+"','"+usrUsr+"','"+UsrCon+"','"+UsrNom+"','"+UsrApe+"',null,null)");
            bd.close();
        }
    }

    public Cursor buscarUsuario(String usrUsr, String usrCon){
        //72006110
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIO WHERE usrUsr='"+usrUsr+"' AND usrCon='"+usrCon+"'",null);
        Log.d("buscarUsuario","BIEEEEEEEn");
        if(cursor.moveToFirst()){
            do{
                Log.d("buscarUsuario",cursor.getString(1));
                Log.d("buscarUsuario",cursor.getString(2));
                return cursor;
            }while (cursor.moveToNext());
        }
        return null;
    }


    public boolean listarUsuarios(){
        //72006110
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIO",null);
        Log.d("listarUsuario","BIEEEEEEEn");
        if(cursor.moveToFirst()){
            do{
                Log.d("listarUsuario","-------------------");
                Log.d("listarUsuario",cursor.getString(0));
                Log.d("listarUsuario",cursor.getString(1));
                Log.d("listarUsuario",cursor.getString(2));
                Log.d("listarUsuario",cursor.getString(3));
                Log.d("listarUsuario",cursor.getString(4));

            }while (cursor.moveToNext());
        }
        cursor.close();
        return false;
    }
    public ArrayList<AfiliadoEntidad> listaAfiliado(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM AFILIADO",null);
        ArrayList<AfiliadoEntidad> listaAfiliado = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                AfiliadoEntidad afiliado = new AfiliadoEntidad();
                afiliado.setId(cursor.getInt(0));
                afiliado.setUsername(cursor.getString(1));
                afiliado.setAfiContra(cursor.getString(2));
                afiliado.setNombre(cursor.getString(3));
                afiliado.setProp(cursor.getString(4));
                afiliado.setLat(cursor.getString(5));
                afiliado.setLon(cursor.getString(6));
                afiliado.setDirecion(cursor.getString(7));
                afiliado.setWeb(cursor.getString(8));
                listaAfiliado.add(afiliado);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return listaAfiliado;

    }

    public String itemsAfiliado(int afiId){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CANJE WHERE afiId = '"+afiId+"'",null);
        String listaItems = "";
        if(cursor.moveToFirst()){
            do{

                listaItems += cursor.getString(3) + "= "+ cursor.getString(4);
                listaItems += "\n";

            }while (cursor.moveToNext());
        }
        cursor.close();
        return listaItems;

    }

}
