package hr.fer.lab.rassus.aggregatormicroservice;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitImplementation implements RestInterface {

	private String baseURL;
	private CurrentReadingApi currentReadingApi;

	public RetrofitImplementation(String url) {
		this.baseURL = url;
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(JacksonConverterFactory.create())
				.build();

		currentReadingApi = retrofit.create(CurrentReadingApi.class);

	}

	@Override
	public Integer getCurrentReading() {
		try {
			Response<Integer> response = currentReadingApi.getCurrentReading().execute();
			if(response.code() != 200) {
				System.out.println("Cannot get current reading.");
				return null;
			}
			return response.body();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
