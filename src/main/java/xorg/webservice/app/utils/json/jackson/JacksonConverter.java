package xorg.webservice.app.utils.json.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import spark.ResponseTransformer;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Created by lonely on 01.09.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class JacksonConverter implements ResponseTransformer {
	
	private static final ObjectMapper mapper = new ObjectMapper ();
	
	static {
		mapper.registerModules ( new Jdk8Module (), new GuavaModule () );
	}
	
	
	public JacksonConverter ( ) {
		
	}
	
	public static String toJson ( Object dtoObject ) {
		
		String jsonToken = null;
		try {
			jsonToken = mapper.writeValueAsString ( dtoObject );
		} catch ( JsonProcessingException e ) {
			e.printStackTrace ();
		}
		return jsonToken;
	}
	
	@SuppressWarnings( "unchecked" )
	public static < T > List< T > fromJsonAsList ( String jsonToken, Class< T > typeClass ) {
		
		List< T > asList = null;
		JavaType collectionType = TypeFactory.defaultInstance ().constructCollectionType ( List.class, typeClass );
		try {
			asList = mapper.readValue ( jsonToken, collectionType );
		} catch ( IOException e ) {
			
		}
		return asList;
	}
	
	@SuppressWarnings( "unchecked" )
	public static < K, V > Map< K, V > fromJsonAsMap (
			String jsonToken,
			Class< K > typeClassK,
			Class< V > typeClassV
	                                                 ) {
		
		Map< K, V > asMap = null;
		
		try {
			
			JavaType collectionType = TypeFactory
					.defaultInstance ()
					.constructMapType ( Map.class, typeClassK, typeClassV );
			
			asMap = mapper.readValue ( jsonToken, collectionType );
			
		} catch ( IOException e ) {
			e.printStackTrace ();
		}
		return asMap;
	}
	
	@Override
	public String render ( Object o ) throws Exception {
		
		return mapper.writeValueAsString ( o );
	}
}

/*
 * The Jackson library can be defined at the class level and be used everywhere because it does not maintain state
 * across different invocations. Since it doesn't maintain state, you can declare it once and use it everywhere
 * (one less line of code if you need to reuse it). Multi threading will have no effect on it. On another note
 * though, looking at it's performance metrics in it's official documentation, it doesn't seem to be an
 * expensive call.
 *
 * With 2.0 and above, above can be augmented by noting that there is an even better way: use ObjectWriter and
 * ObjectReader objects, which can be constructed by ObjectMapper. They are fully immutable, thread-safe,
 * meaning that it is not even theoretically possible to cause thread-safety issues (which can occur with
 * ObjectMapper iff code tries to re-configure instance).
 */