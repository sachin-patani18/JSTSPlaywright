# Salesforce Login and Logout Test Plan

## 1. Test Plan ID and Title

| Field | Value |
| --- | --- |
| Test Plan ID | TP-LOCAL-SF-AUTH-001 |
| Title | Salesforce Production Login, Remember Me, and Logout Test Plan |
| Version | 1.0 |
| Status | Draft for stakeholder review |
| Target | Salesforce production sign-in |
| Test window | Not provided |
| Owner and approver | Not provided |

This document defines planned testing. It does not report executed tests or verified Salesforce behavior.

## 2. Objective and References

### Objective

Define controlled, reproducible testing for username-and-password sign-in, the “Remember me” option, logout, and session protection. Cover functional and regression behavior, limited browser compatibility, and basic accessibility on Chrome for Windows desktop.

### References and evidence

- Target URL supplied for this plan: [https://login.salesforce.com/?locale=in](https://login.salesforce.com/?locale=in)
- The RICE-POT Test Plan profile in [`04_RICE_POT_Generic_QA_Template.md`](../04_RICE_POT_Generic_QA_Template.md)
- No formal business requirements or acceptance criteria were supplied. The `REQ-LOCAL-*` identifiers below are local planning references, not Salesforce requirement IDs.

### Requirement status

Expected behaviors below are proposed test objectives based on the scope confirmed for this plan. They require stakeholder approval before execution. Salesforce UI behavior, error text, account policy, and production access have not been independently verified.

## 3. In Scope and Out of Scope

### In scope

- Username-and-password authentication using approved test accounts.
- Successful sign-in and arrival at the Salesforce home page.
- Rejection of invalid credentials and required-field validation, without asserting unconfirmed exact error wording.
- “Remember me” behavior: retain the username on a later visit, but do not store or prefill the password.
- Logout, return to the sign-in page, and protection of authenticated pages after logout.
- Failed-attempt lockout behavior only when the approved policy and a suitable test account are available. Testing must not exceed the approved attempt limits.
- Functional and focused regression testing.
- Basic accessibility checks for keyboard operation, visible focus, labels, and accessible names.
- Browser coverage limited to Chrome on Windows desktop.

### Out of scope

- Multi-factor authentication (MFA), single sign-on (SSO), and federated identity flows.
- Password reset and account recovery.
- Mobile and responsive testing, and browsers other than Chrome.
- Penetration testing, broad security assessment, performance, load, and stress testing.
- Testing against real customer records or unapproved production accounts.
- Automation implementation and execution; this is a test plan only.

## 4. Requirements and Planned Coverage

All local objectives in this section are proposed and must be confirmed before execution.

| Local ID | Proposed objective | Planned coverage | Priority (proposed) | Acceptance observation |
| --- | --- | --- | --- | --- |
| REQ-LOCAL-01 | An active approved test account can sign in with valid credentials. | Positive functional; regression | High | Authentication succeeds and the user reaches the Salesforce home page. |
| REQ-LOCAL-02 | Invalid credentials do not authenticate a user. | Negative functional; regression | High | No authenticated session is created. Exact error text is not specified. |
| REQ-LOCAL-03 | Required username and password fields prevent sign-in when missing. | Negative and boundary functional | High | Missing required input does not create an authenticated session. Validation details are pending confirmation. |
| REQ-LOCAL-04 | “Remember me” retains the username only. | Functional; privacy-focused regression | Medium | On a later visit in the same supported browser profile, the username is retained; the password is neither stored nor prefilled. |
| REQ-LOCAL-05 | Logout ends the authenticated session. | Functional; regression | High | Logout returns to sign-in; a previously protected page cannot be accessed as an authenticated user without signing in again. |
| REQ-LOCAL-06 | Repeated failed attempts follow the approved account lockout policy. | Policy-dependent negative functional | High | Lockout or other configured response matches the documented policy. Do not run without approved limits and a designated test account. |
| REQ-LOCAL-07 | Sign-in controls can be operated and understood using basic accessibility practices. | Accessibility review; regression | Medium | Keyboard users can reach and operate controls; focus is visible; fields and controls have usable labels or accessible names. Detailed conformance target is not provided. |

Exact error messages, validation copy, lockout thresholds, session timeout rules, and accessibility conformance level are not provided. Do not treat them as acceptance criteria until approved.

## 5. Test Approach, Levels, and Types

### Approach

1. Review and approve the proposed local objectives, production test authorization, account policy, test data, and entry criteria.
2. Prepare the approved Chrome/Windows environment and confirm the target URL and account prerequisites.
3. Execute positive and negative functional scenarios, recording actual observations and evidence without exposing credentials.
4. Verify “Remember me” in an approved, isolated browser profile. Clear test state after execution.
5. Verify logout and protected-page behavior using the approved test account.
6. Run lockout checks only when the account policy, attempt limit, reset procedure, and dedicated test account are confirmed.
7. Perform the scoped keyboard and accessible-name checks.
8. Record results, defects, deviations, and remaining risks. Re-run impacted checks after fixes as agreed.

### Levels and types

- **System/functional:** Sign-in, rejected credentials, required fields, “Remember me,” logout, and session protection.
- **Regression:** Recheck the in-scope authentication journey after relevant changes.
- **Compatibility:** Chrome on Windows desktop only; precise browser and OS versions must be recorded at execution.
- **Accessibility:** Basic manual keyboard, focus, and label/name checks only; this is not a full accessibility audit.
- **Security-related policy check:** Account lockout behavior only as defined by the approved policy. No penetration testing is included.

### Execution and evidence

Test cases and their exact count are to be defined after the objectives and detailed acceptance criteria are approved. Each case should have preconditions, synthetic or approved test data, numbered steps, and observable expected results. Mark results “Not Run” until execution evidence exists. Store screenshots or logs only in an approved location and redact usernames or other sensitive information where required.

## 6. Environment, Tools, Access, and Test Data

| Item | Planned value or prerequisite |
| --- | --- |
| Target URL | `https://login.salesforce.com/?locale=in` |
| Target environment | Salesforce production, as selected |
| Browser/platform | Chrome on Windows desktop; exact versions Not provided |
| Network/access | Production access and any organization access controls must be authorized; details Not provided |
| Test account | An approved active test user with permission to reach the Salesforce home page; account details Not provided |
| Invalid credentials | Approved non-secret test inputs; do not use another person's account |
| Lockout account | Dedicated test account and documented lockout/reset procedure required before lockout testing |
| Test data | Synthetic or approved test account data only; no real customer data |
| Tools | Browser and approved evidence/defect tracking tools; specific tools Not provided |
| Secrets | Credentials must remain in the approved secret store and must not be placed in this plan, test cases, screenshots, or logs |
| Browser state | Use an isolated, approved browser profile; clear cookies and local state when needed to restore a known baseline |

### Production safeguards

- Obtain explicit authorization and an agreed test window before any production execution.
- Use only designated test accounts and approved test inputs.
- Do not perform uncontrolled repeated failures, attempt to lock a shared account, or trigger unapproved notifications or account changes.
- Confirm the lockout threshold and account recovery/reset contact before any lockout scenario.
- Stop if a test affects a non-test user, production data, or service availability; follow the organization's incident process.

## 7. Entry and Exit Criteria

The following criteria are proposed for review and are not yet approved organizational policy.

### Entry criteria

- Stakeholders approve the scope and local objectives in Section 4.
- Production test authorization, test window, and responsible contact are documented.
- Approved active test account and synthetic/approved invalid inputs are available.
- Chrome and Windows versions are recorded, and the target URL is reachable.
- Expected home-page state, required-field behavior, and logout/session behavior are agreed.
- Lockout testing is excluded until documented limits, a dedicated account, and a reset procedure are available.
- Defect severity definitions, reporting location, and escalation contacts are agreed.

### Exit criteria (proposed)

- 100% of approved in-scope test cases have an execution status and recorded result.
- All executed cases pass, or each failure/blocker has a linked defect or documented, approved exception.
- No open Critical or High severity defects remain for the approved scope, unless a named stakeholder accepts the documented exception.
- Any untested or blocked coverage, including policy-dependent lockout checks, is listed with its impact and owner.
- Test evidence and the final test summary are stored in the approved location without exposing secrets.

## 8. Roles, Responsibilities, Estimates, and Schedule

| Role | Responsibility | Assignment |
| --- | --- | --- |
| Test lead | Confirm scope, coordinate execution, review results, and report risks | Not provided |
| Salesforce/business owner | Approve expected behavior, production access, and any exception | Not provided |
| Account administrator | Provision/reset designated test users and confirm lockout policy | Not provided |
| Tester | Execute approved cases, capture evidence, and report defects | Not provided |
| Developer/support contact | Triage and resolve defects | Not provided |

Release, test window, start/end dates, effort estimate, and approval schedule are not provided and must be agreed before execution.

## 9. Defect Management and Reporting

- Record defects in the approved tracking system; the tool and required fields are not provided.
- Include a concise title, environment/browser versions, preconditions, sanitized test data, reproducible steps, expected and actual results, evidence reference, and proposed severity.
- Separate observed behavior from expected behavior. Do not state exact Salesforce messages unless captured and approved.
- Treat severity and priority as proposed until triaged by the responsible owner.
- Report execution progress, pass/fail/blocked counts, open defects, risks, and scope deviations at an agreed cadence. Cadence and escalation contacts are not provided.
- Never include passwords, tokens, session cookies, or other secrets in defect reports or evidence.

## 10. Risks, Dependencies, Assumptions, and Open Questions

### Risks

- Production tests may lock or disrupt accounts if failed attempts are not controlled.
- Salesforce behavior, branding, policies, or authentication flows may change; re-confirm the interface and policy before execution.
- A production account may have organization-specific access controls not captured in this plan.
- Browser persistence behavior may be affected by browser settings or organization policy.
- No formal requirements or approved exact error messages were supplied; proposed objectives may need revision.

### Dependencies

- Stakeholder approval of the local objectives and acceptance observations.
- Authorized production test window and named escalation contact.
- Designated test account, approved invalid inputs, and reset procedure.
- Documented account lockout policy if lockout coverage is required.
- Agreement on accessibility target, defect process, and test evidence location.

### Assumptions

- The stated URL and `locale=in` are the intended production sign-in entry point.
- The target successful sign-in state is the Salesforce home page.
- “Remember me” should retain the username only and never retain or prefill the password.
- Logout should return to sign-in and prevent access to protected content without re-authentication.
- Exact invalid-login message wording is not an acceptance criterion unless supplied later.

### Open questions

1. What exact Chrome and Windows versions are supported?
2. What designated production test account and access permissions are available?
3. What are the approved lockout threshold, reset procedure, and lockout test account?
4. What required-field and invalid-credential outcomes/messages are approved?
5. What browser persistence expectation and cleanup procedure apply to “Remember me”?
6. What accessibility conformance target, if any, is required?
7. Who owns test approval, execution, defect triage, and production escalation, and what is the test window?
8. Which defect-tracking and evidence-storage tools should be used?

## 11. Suspension and Resumption Criteria

### Suspend testing when

- Production authorization or the approved test window is absent or withdrawn.
- A test account is locked unexpectedly, a shared/non-test user is affected, or account behavior risks production disruption.
- The target URL or expected behavior differs materially from the approved plan.
- A Critical/High impact issue suggests further execution may cause data exposure, account impact, or service disruption.
- Required access, test data, or environment is unavailable or unstable.

### Resume testing when

- The issue or dependency is resolved and the responsible owner approves resumption.
- The test account and environment have been restored to an agreed state.
- Any required scope, data, or procedure updates are approved and communicated.

## 12. Test Deliverables and Approval

### Deliverables

- This test plan.
- Detailed test cases and traceability to approved local objectives, to be prepared after acceptance criteria are confirmed.
- Execution results and sanitized evidence, if execution is authorized.
- Defect records and a final test summary, if applicable.

### Approval

| Approver | Name | Decision | Date |
| --- | --- | --- | --- |
| Business/Salesforce owner | Not provided | Pending | Not provided |
| Test lead | Not provided | Pending | Not provided |

Approval of this document authorizes the plan for execution only if production access and test-window approval are also granted by the appropriate owner.
