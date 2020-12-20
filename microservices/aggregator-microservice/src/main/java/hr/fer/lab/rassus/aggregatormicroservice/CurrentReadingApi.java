package hr.fer.lab.rassus.aggregatormicroservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrentReadingApi {
	@GET("/current-reading")
	Call<Integer> getCurrentReading();
}
