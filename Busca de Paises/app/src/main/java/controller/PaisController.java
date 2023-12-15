package controller;
import android.content.Context;
import java.util.ArrayList;
import dao.PaisDao;
import model.Pais;
import retrofit.RetrofitConfig;
import dto.PaisDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class PaisController {
    private static Context context;
    public static void getViaPais(Context context){
        try{
            retrofit2.Call<ArrayList <PaisDTO>> call = new RetrofitConfig().paisService().getPaisDtoCall();
            call.enqueue(new Callback<ArrayList<PaisDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PaisDTO>> call, Response<ArrayList<PaisDTO>> response) {
                    ArrayList<PaisDTO> listaPais = response.body();
                    for (int i = 0 ; i <listaPais.size(); i++){
                        PaisDTO pais = listaPais.get(i);

                        salvar(pais.getCodigo(), pais.getDescricao(),context);

                    }
                }
                @Override
                public void onFailure(Call<ArrayList<PaisDTO>> call, Throwable t) {
                }
            });
        }catch (Exception ex){}
    }
    public static String salvar(int codigo, String descricao, Context context){
        try {
            Pais pais = new Pais();

            pais.setCodio(codigo);
            pais.setDescricao(descricao);

            PaisDao.getInstancia(context).insert(pais);
        } catch (Exception ex) {
            return "Erro ao gravar pais." + ex.getMessage();
        }
        return null;
    }
    public static ArrayList<Pais> retornar(Context context){
        return PaisDao.getInstancia(context).getAll();
    }
}
