package retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import service.IPais;

public class RetrofitConfig {

    private Retrofit retrofit;
    private static final String BASE_URL = "https://falabr.cgu.gov.br/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

    public IPais paisService() {
        return this.retrofit.create(IPais.class);
    }


}
