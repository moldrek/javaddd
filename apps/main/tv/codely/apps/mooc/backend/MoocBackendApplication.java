package tv.codely.apps.mooc.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.apps.mooc.backend.command.AnotherFakeCommand;
import tv.codely.apps.mooc.backend.command.FakeCommand;
import tv.codely.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"tv.codely.shared", "tv.codely.mooc", "tv.codely.apps.mooc"}
)
public class MoocBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
            put("fake", FakeCommand.class);
            put("another_fake", AnotherFakeCommand.class);
        }};
    }
}
