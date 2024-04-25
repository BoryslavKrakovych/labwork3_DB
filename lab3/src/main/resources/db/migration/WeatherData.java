import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;

public class BeforeMigrateLogger implements Callback {
    @Override
    public boolean supports(Event event, Context context) {
        return event == Event.BEFORE_MIGRATE;
    }

    @Override
    public void handle(Event event, Context context) {
        System.out.println("About to start migration...");
    }

    @Override
    public String getCallbackName() {
        return "Before Migrate Logger";
    }
}
