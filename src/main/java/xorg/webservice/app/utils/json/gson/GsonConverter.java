package xorg.webservice.app.utils.json.gson;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import spark.ResponseTransformer;
import xorg.webservice.app.utils.json.jsonutils.ListFromJson;
import xorg.webservice.app.utils.json.jsonutils.MapFromJson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by lonely on 24.08.16.
 *
 * @author : Alexander Balyshyn
 */


public class GsonConverter implements ResponseTransformer {
	
	private static final Gson googleJson = new Gson ();
	
	public GsonConverter ( ) {
		
	}
	
	/* Simple serialization */
	public static String toJson ( Object dtoObject ) {
		
		return googleJson.toJson ( dtoObject );
	}
	
	public static < T > String toJson ( Object dtoObject, Class< T > typeClass ) {
		
		Type typeParam = new TypeToken< T > () {
			
		}.getType ();
		return googleJson.toJson ( dtoObject, typeParam == null ? typeClass : typeParam );
	}
	
	public static < T > T fromJson (String jsonToken, java.lang.Class typeClass ) {
		
		return (T) googleJson.fromJson ( jsonToken, typeClass );
	}
	
	public static < T > T fromJson ( String jsonToken, Type type ) {
		
		return googleJson.fromJson ( jsonToken, type );
	}
	
	public static < T > List< T > fromJsonAsArray ( String jsonToken, Class< T[] > typeClass ) {
		
		T[] array = googleJson.fromJson ( jsonToken, typeClass );
		return Arrays.asList ( array );
	}
	
	public static < T > List< T > fromJsonAsList ( String jsonToken, Class< T > typeClass ) {
		
		return googleJson.fromJson ( jsonToken, new ListFromJson<> ( typeClass ) );
	}
	
	public static < K, V > Map< K, V > fromJsonAsMap (
			String jsonToken,
			Class< K > kClass,
			Class< V > vClass
	                                                 ) {
		
		return googleJson.fromJson ( jsonToken, new MapFromJson<> ( kClass, vClass ) );
	}
	
	
	@Override
	public String render ( Object model ) throws Exception {
		
		return googleJson.toJson ( model );
	}
	
	public static Type getType ( Class< ? > rawClass, Class< ? > classParameter ) {
		
		return new ParameterizedType () {
			
			@Override
			public Type[] getActualTypeArguments ( ) {
				
				return new Type[] { classParameter };
			}
			
			@Override
			public Type getRawType ( ) {
				
				return rawClass;
			}
			
			@Override
			public Type getOwnerType ( ) {
				
				return null;
			}
		};
	}
}


/*
 * The Gson library can be defined at the class level and be used everywhere because it does not maintain state
 * across different invocations. Since it doesn't maintain state, you can declare it once and use it everywhere
 * (one less line of code if you need to reuse it). Multi threading will have no effect on it. On another note
 * though, looking at it's performance metrics in it's official documentation, it doesn't seem to be an
 * expensive call.
 */
