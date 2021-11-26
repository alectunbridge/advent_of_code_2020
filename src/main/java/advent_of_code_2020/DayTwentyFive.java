package advent_of_code_2020;

public class DayTwentyFive {

    public long findLoopSize(long subjectNumber, long publicKey) {
        long value = 1;
        long loopSize = 0;
        while (value != publicKey) {
            value *= subjectNumber;
            value %= 20201227;
            loopSize++;
        }
        return loopSize;
    }

    public long calculateEncryptionKey(long subjectNumber, long otherLoopSize) {
        long value = 1;
        for (long loopCount = 0; loopCount < otherLoopSize; loopCount++) {
            value *= subjectNumber;
            value %= 20201227;
        }
        return value;
    }
}
