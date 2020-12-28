package advent_of_code_2020;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DaySixteen {
    public static final Pattern FIELD_PATTERN = Pattern.compile("([^:]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)");

    private List<List<Integer>> tickets = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private Set<Integer> allowedNumbers;
    private boolean readingNearbyTickets = false;
    private boolean readingYourTicket = false;
    private List<Integer> yourTicket;

    public DaySixteen(String... input) {
        for (String line : input) {
            Matcher m = FIELD_PATTERN.matcher(line);
            if ("".equals(line)) {
//                System.out.println("skipping blank line");
            } else if ("your ticket:".equals(line)) {
                readingYourTicket = true;
            } else if ("nearby tickets:".equals(line)) {
                readingNearbyTickets = true;
            } else if (m.matches()) {
                fields.add(new Field(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5)));
            } else if (readingNearbyTickets) {
                List<Integer> ticket =
                        Arrays.stream(line.split(","))
                                .map(Integer::valueOf)
                                .filter(this::validNumber)
                                .collect(Collectors.toList());
                if (ticket.size() == fields.size()) {
                    tickets.add(ticket);
                }
            } else if (readingYourTicket) {
                yourTicket = Arrays.stream(line.split(",")).map(Integer::valueOf).collect(Collectors.toList());
                tickets.add(yourTicket);
            }
        }
    }

    private boolean validNumber(Integer integer) {
        if (allowedNumbers == null) {
            allowedNumbers = fields.stream().map(Field::getAllowedNumbers).flatMap(Set::stream).collect(Collectors.toSet());
        }
        return allowedNumbers.contains(integer);
    }

    public int partOneAnswer() {
        return 0;
    }

    public List<String> findFieldOrder() {
        List<Set<Integer>> ticketFieldRanges = new ArrayList<>();
        for (int ticketFieldIndex = 0; ticketFieldIndex < fields.size(); ticketFieldIndex++) {
            Set<Integer> values = new HashSet<>();
            for (List<Integer> ticket: tickets) {
                values.add(ticket.get(ticketFieldIndex));
            }
            ticketFieldRanges.add(values);
        }

        List<String> result = new ArrayList<>(Collections.nCopies(fields.size(),""));
        while(!fields.isEmpty()) {
            for (int i = 0, ticketFieldRangesSize = ticketFieldRanges.size(); i < ticketFieldRangesSize; i++) {
                Set<Integer> ticketFieldRange = ticketFieldRanges.get(i);
                int possibleFields = 0;
                Field matchedField = null;
                for (Field field : fields) {
                    if (field.getAllowedNumbers().containsAll(ticketFieldRange)) {
                        matchedField = field;
                        possibleFields++;
                    }
                }
                if (possibleFields == 1) {
                    result.set(i, matchedField.getName());
                    fields.remove(matchedField);
                }
            }
        }
        return result;
    }


    public long partTwoAnswer() {
        long result = 1;
        List<String> fieldOrder = findFieldOrder();
        for (int i = 0; i < fieldOrder.size(); i++) {
            if(fieldOrder.get(i).startsWith("departure")){
                System.out.printf("index: %d, name: %s, value: %s\n", i, fieldOrder.get(i), yourTicket.get(i));
                result *= yourTicket.get(i);
            }
        }
        return result;
    }


}
