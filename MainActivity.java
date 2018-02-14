public class MainActivity extends AppCompatActivity  {
Button btn ;
TextView txt,tiptxt;
EditText edittxt;
ImageView img1,img2,img3,img4,img5,img6;
     boolean tip=true;
//Mehmet Olgun 23.01.2018
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn =findViewById(R.id.btn);
    txt = findViewById(R.id.sonuctxt);
    edittxt = findViewById(R.id.yazikutusu);
    tiptxt = findViewById(R.id.tipdegistirid);
    img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

    }
    boolean hatali=false;
    Random rnd = new Random(10);
    public void btntik(View v)
    {
        try{
            int yazilan =Integer.parseInt( edittxt.getText().toString());
        int kalan=0,sayac=0;
        int  dizi[]= new int[100];
        if(tip==true)
        {

            while(yazilan>0)
            {
                kalan = yazilan%2;
                dizi[sayac] = kalan;
                sayac++;
                if(yazilan==1)break;
                yazilan = yazilan/2;

            }
            txt.setText("");
            for(int i=sayac-1;i>=0;i--)
            {
                txt.setText(txt.getText().toString()+""+dizi[i]);
            }
        }
        else
        {
            String yazilanstr = String.valueOf(yazilan);
            int uzunluk = yazilanstr.length();
            txt.setText("");
            int toplam=0;
            int carpimtop=1;
            int y=0;
            for( y=uzunluk-1;y>=0;y--)
            {
                int indis = y-(uzunluk-1);
                indis =indis*-1;
                String sayi = String.valueOf(yazilanstr.charAt(indis));

                int sayi2 = Integer.parseInt(sayi);
                if(sayi2!=1 && sayi2!=0)
                {
                    hatali=true;
                }
                if(sayi2!=0 && y!=0)
                {
                    for(int AB=1;AB<=y;AB++)
                    {
                        carpimtop *= 2;
                    }
                    toplam+=carpimtop;
                    carpimtop=1;
                }
               if(y==0)
               {
                   if(sayi2!=0)
                   {
                       toplam++;
                   }
               }

            }
            if(hatali==true)
            {
                txt.setText("Sadece 1 ve 0");
                hatali=false;
            }
            else
            {
                txt.setText(""+toplam);
            }
        }

        }catch (NumberFormatException e)
        {
            txt.setText("Sayý Çok Büyük :)");
       

        }
    }

    public void tiptik(View v)
    {
        if(tip==true)
        {
            tiptxt.setText("Ýkiliyi Sayýya");

            tip=false;
            img6.setImageResource(R.drawable.bir);
            img5.setImageResource(R.drawable.zero);
            img1.setImageResource(R.drawable.zero);
            img2.setImageResource(R.drawable.bir);
            img3.setImageResource(R.drawable.okk);
            img4.setImageResource(R.drawable.dokuz);

        }
        else
        {
            tiptxt.setText("Sayýyý Ýkiliye");
            tip = true;
            img6.setImageResource(R.drawable.dokuz);
            img5.setImageResource(R.drawable.okk);
            img1.setImageResource(R.drawable.bir);
            img2.setImageResource(R.drawable.zero);
            img3.setImageResource(R.drawable.zero);
            img4.setImageResource(R.drawable.bir);
        }

    }
}