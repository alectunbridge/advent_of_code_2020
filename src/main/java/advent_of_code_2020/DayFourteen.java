package advent_of_code_2020;

import org.apache.commons.math3.FieldElement;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DayFourteen {

    private char[] mask;
    private Map<Long, Long> memory;

    public DayFourteen(MemInstructionExecutor memInstructionExecutor, String... input) {
        memory = new HashMap<>();
        mask = new char[36];
        Arrays.fill(mask, 'X');
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
        Long result = memory.get(address);
        return result == null? 0: result;
    }

    public long sumMemoryContents() {
        return memory.values().stream().mapToLong(Long::longValue).sum();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> input = Files.readAllLines(Path.of(DayFourteen.class.getClassLoader().getResource("day_fourteen.txt").toURI()));
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart1(), input.toArray(new String[0]));
        System.out.println(dayFourteen.sumMemoryContents());

        DayFourteen part2 = new DayFourteen(new MemInstructionExecutorPart2(), input.toArray(new String[0]));
        System.out.println(part2.sumMemoryContents());
    }


}

interface MemInstructionExecutor {
    void execute(String memInstruction, char[] mask, Map<Long, Long> memory);
}

class MemInstructionExecutorPart1 implements MemInstructionExecutor {

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

    public long applyMask(long value, char[] mask) {
        char[] paddedValueAsBits = String.format("%36s", Long.toBinaryString(value))
                .replace(' ', '0').toCharArray();

        for (int i = 0; i < mask.length; i++) {
            char maskBit = mask[i];
            if ('X' == maskBit) {
                continue;
            }
            paddedValueAsBits[i] = mask[i];
        }
        return Long.parseUnsignedLong(String.valueOf(paddedValueAsBits), 2);
    }
}

class MemInstructionExecutorPart2 implements MemInstructionExecutor {
    @Override
    public void execute(String memInstruction, char[] mask, Map<Long, Long> memory) {
        Pattern pattern = Pattern.compile("mem\\[(\\d*)] = (\\d*)");
        Matcher matcher = pattern.matcher(memInstruction);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Can't parse mem instruction: " + memInstruction);
        }
        long initialAddress = Long.parseLong(matcher.group(1));
        long value = Long.parseLong(matcher.group(2));

        List<Long> addresses = applyMask(initialAddress, mask);

        addresses.forEach(address -> memory.put(address, value));
    }

    private List<Long> applyMask(long intialAddress, char[] mask) {
        char[] paddedValueAsBits = String.format("%36s", Long.toBinaryString(intialAddress))
                .replace(' ', '0').toCharArray();

        for (int i = 0; i < mask.length; i++) {
            char maskBit = mask[i];
            if ('0' == maskBit) {
                continue;
            }
            paddedValueAsBits[i] = mask[i];
        }

        return replaceXs(String.valueOf(paddedValueAsBits)).stream().map(l->Long.parseLong(l,2)).collect(Collectors.toList());
    }

    List<String> replaceXs(String paddedValueAsBits) {
        List<String> addresses = new ArrayList<>();
        int countOfXs = 0;
        for (char digit : paddedValueAsBits.toCharArray()) {
            if('X' == digit){
                countOfXs++;
            }
        }

        for (int combination = 0; combination < Math.pow(2,countOfXs); combination++) {
            String xValues = String.format("%" + countOfXs + "s", Long.toBinaryString(combination)).replace(' ', '0');
            String newCombination = paddedValueAsBits;
            for (int xIndex = 0; xIndex < countOfXs; xIndex++) {
                newCombination = newCombination.replaceFirst("X",String.valueOf(xValues.charAt(xIndex)));
            }
            addresses.add(newCombination);
        }
        return addresses;
    }

    List<String> replaceXsRecursive(String paddedValueAsBits) {
        if(!paddedValueAsBits.contains("X")){
            return Collections.singletonList(paddedValueAsBits);
        }
        List<String> result = new ArrayList<>();
        result.addAll(replaceXs(paddedValueAsBits.replaceFirst("X","0")));
        result.addAll(replaceXs(paddedValueAsBits.replaceFirst("X","1")));
        return result;
    }

}
