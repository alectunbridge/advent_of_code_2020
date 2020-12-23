package advent_of_code_2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFourteen {

    private char[] mask;
    private Map<Long,Long> memory;

    public DayFourteen(MemInstructionExecutor memInstructionExecutor, String... input) {
        memory = new HashMap<>();
        mask = new char[36];
        Arrays.fill(mask,'X');
        for (String line : input) {
            if ("mem".equals(line.substring(0, 3))) {
                memInstructionExecutor.execute(line, mask, memory);
            } else {
                this.mask = line.substring(7).toCharArray();
            }
        }
    }

    public String getMask() {
        return String.valueOf(mask);
    }

    public long getLocation(long address) {
        return memory.get(address);
    }

    private Map<Long,Long> getMemory() {
        return memory;
    }

    public long sumMemoryContents() {
        return memory.values().stream().mapToLong(Long::longValue).sum();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> input = Files.readAllLines(Path.of(DayFourteen.class.getClassLoader().getResource("day_fourteen.txt").toURI()));
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart1(), input.toArray(new String[0]));
        System.out.println(dayFourteen.sumMemoryContents());
    }

    public static class MemInstructionExecutorPart1 implements MemInstructionExecutor {

        @Override
        public void execute(String memInstruction, char[] mask, Map<Long, Long> memory) {
            Pattern pattern = Pattern.compile("mem\\[(\\d*)] = (\\d*)");
            Matcher matcher = pattern.matcher(memInstruction);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Can't parse mem instruction: " + memInstruction);
            }
            long bitmaskedValue = applyMask(Long.parseLong(matcher.group(2)), mask);
            memory.put(Long.parseLong(matcher.group(1)), bitmaskedValue);
        }

        @Override
        public long applyMask(long value, char[] mask) {
            char[] paddedValueAsBits = String.format("%36s", Long.toBinaryString(value))
                    .replace(' ', '0').toCharArray();

            for (int i = 0, charArrayLength = mask.length; i < charArrayLength; i++) {
                char maskBit = mask[i];
                if ('X' == maskBit) {
                    continue;
                }
                paddedValueAsBits[i] = mask[i];
            }
            return Long.parseUnsignedLong(String.valueOf(paddedValueAsBits),2);
        }
    }
}
