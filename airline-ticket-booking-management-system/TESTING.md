# Testing

| Test ID | Test case | Input | Expected result | Status |
|---|---|---|---|---|
| T01 | Display flights | Menu 1 | All sample flights are displayed | PASS |
| T02 | Search valid route | Delhi -> Bengaluru | UK810 is displayed | PASS |
| T03 | Search invalid route | Delhi -> Chennai | No matching flights found | PASS |
| T04 | Valid booking | UK810 + passenger details | Booking ID generated and seat reduced | PASS |
| T05 | Empty passenger name | Blank name | Validation error shown | PASS |
| T06 | View history | Menu 4 | Booking record is displayed | PASS |
| T07 | Valid cancellation | B0001 | Booking becomes CANCELLED and seat is released | PASS |
| T08 | Invalid cancellation | B9999 | Error message shown | PASS |
| T09 | Persistence | Restart after booking | Previous data is loaded from `airline_data.dat` | PASS |
| T10 | Notification thread | Successful booking | Confirmation notification is printed by a separate thread | PASS |

## Compilation Test

The project was compiled with Java JDK 17 using:

```bash
javac -d out src/airline/*.java
```

The command completed successfully.
