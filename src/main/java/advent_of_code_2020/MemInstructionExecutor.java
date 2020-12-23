package advent_of_code_2020;

import java.util.Map;

public interface MemInstructionExecutor {
    void execute(String memInstruction, char[] mask, Map<Long, Long> memory);

    long applyMask(long value, char[] mask);
}
