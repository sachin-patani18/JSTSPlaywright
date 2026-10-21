# Draft Test Plans

This folder contains a draft Salesforce production sign-in test plan in editable Markdown and PDF formats. It is a planning artifact, not a record of test execution or verified Salesforce behavior.

## Salesforce login and logout plan

- [Salesforce_Login_Test_Plan.md](Salesforce_Login_Test_Plan.md) — editable source and full test-plan details.
- [Salesforce_Login_Test_Plan.pdf](Salesforce_Login_Test_Plan.pdf) — PDF version for viewing or sharing.

The plan covers username/password sign-in, invalid credentials and required fields, “Remember me,” logout and session protection, policy-dependent lockout checks, and basic accessibility checks for Chrome on Windows desktop.

## Review before execution

The plan is for stakeholder review, not an execution report. Its local coverage objectives and exit criteria are proposed; formal requirements, exact error messages, account policies, test-account details, environment versions, test dates, owners, and approvals remain to be confirmed. Production execution requires explicit authorization and an approved test window. Lockout testing must not be performed without an approved policy, a designated test account, and a reset procedure.
