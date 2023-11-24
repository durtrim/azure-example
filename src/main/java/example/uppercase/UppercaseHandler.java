package example.uppercase;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UppercaseHandler {

	@Autowired
	private Function<Mono<String>, Mono<String>> uppercase;

	@FunctionName("uppercase")
	public CompletableFuture<String> execute(
		@HttpTrigger(
			name = "req",
			methods = {HttpMethod.GET, HttpMethod.POST},
			authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
		ExecutionContext context
	) {
		context.getLogger().warning("Using Java (" + System.getProperty("java.version") + ")");
		return Mono.just(request)
				.map(r -> r.getBody().orElse(""))
				.flatMap(r -> uppercase.apply(Mono.just(r)))
				.toFuture();
	}
}
