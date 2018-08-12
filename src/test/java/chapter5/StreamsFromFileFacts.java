package chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamsFromFileFacts {
    @Test
    public void should_return_unique_string_count() {
        try (Stream<String> lines = Files.lines(Paths.get("./data.txt"), Charset.defaultCharset())) {
            long count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            Assert.assertEquals(3, count);
        } catch (IOException e) { }
    }
}
