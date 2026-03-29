# Product Backlog: Virtual Bank for Kids

| Story ID | User Story | Acceptance Criteria | Priority | Estimation (SP) | Iteration |
| :------- | :--------- | :------------------ | :------- | :------------- | :-------- |
| US001 | As a child, I want to create several types of virtual accounts (Current, Savings) so I can organize my money. | - Create account name<br>- View balance in each account<br>- Persistent storage | High | 5 | 1 |
| US002 | As a kid, I want to earn pocket money by doing tasks set by my parents. | - List tasks<br>- Mark task as completed<br>- Reward added to balance | High | 8 | 1 |
| US003 | As a kid, I want to set savings goals with progress tracking. | - Create goal title/amount<br>- Transfer money from current to savings<br>- View progress bar (%) | Medium | 5 | 2 |
| US004 | As a kid, I want to withdraw my virtual money. | - Subtract from balance<br>- Add to transaction history<br>- Prevent negative balance | High | 3 | 1 |
| US005 | As a parent, I want to set tasks and rewards for my kids. | - Add task name<br>- Set reward amount<br>- View task status | Medium | 5 | 2 |
| US006 | As a kid, I want to see history of all my transactions. | - List of deposits/withdrawals<br>- Timestamps included | Low | 3 | 3 |
| US007 | As a user, I want the application to work offline without a database. | - JSON/CSV storage<br>- No internet required | High | 8 | 1 |
| US008 | As a kid, I want a colorful and easy to use GUI. | - JavaFX implementation<br>- Intuitive navigation | High | 13| 1 |

## Iteration Plan

### Iteration 1 (MVP)
- Account Creation (Current/Savings)
- Simple Persistence (Serialized objects)
- Task Completion/Rewards
- Basic Dashboard GUI

### Iteration 2 (Features)
- Savings Goals Tracking
- Parent Task Setting UI
- Advanced Error Handling (Invalid amounts)

### Iteration 3 (Polish)
- Transaction History View
- UI/UX Polish with Colors and Icons
- Final Documentation (User Manual)
