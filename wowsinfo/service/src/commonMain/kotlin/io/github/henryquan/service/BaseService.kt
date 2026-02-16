import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect fun getEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig>

/**
 * Singleton HttpClient provider following Ktor 3 best practices.
 * Reusing a single client instance improves performance by sharing connection pools.
 */
object HttpClientProvider {
    val client = HttpClient(getEngineFactory()) {
        // Content negotiation for JSON serialization
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }

        // Request timeout configuration
        install(HttpTimeout) {
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 10000
            socketTimeoutMillis = 10000
        }

        // Default headers for all requests
        defaultRequest {
            header(HttpHeaders.UserAgent, "WowsInfo/1.0")
        }
    }
}

abstract class BaseService {
    abstract val baseUrl: String

    /**
     * Shared HttpClient instance following Ktor 3 best practices.
     * The client is configured with content negotiation, timeouts, and default headers.
     */
    open val client = HttpClientProvider.client

    /**
     * Performs a GET request and deserializes the response.
     * @param path The API endpoint path relative to baseUrl.
     * @param params Query parameters for the request.
     * @return The deserialized response object.
     */
    suspend inline fun <reified T> getObject(
        path: String,
        params: Map<String, String> = emptyMap()
    ): T {
        val response = client.get("$baseUrl$path") {
            params.forEach { (key, value) ->
                parameter(key, value)
            }
        }
        return response.body<T>()
    }
}
