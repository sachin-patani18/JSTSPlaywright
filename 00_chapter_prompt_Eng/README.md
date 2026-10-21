# QA Prompt Engineering and Automation Resources

This section contains RICE-POT prompt-engineering references, a Selenium-based Java automation framework, and a Salesforce login/logout test plan. JavaScript lessons are maintained in the numbered chapter folders at the repository root; see the [project overview](../README.md).

## Repository contents

| Path | Description |
| --- | --- |
| [`00_RICE_POT_Fullname.md`](00_RICE_POT_Fullname.md) | RICE-POT framework overview |
| [`01_RICE_POT_Prompt.md`](01_RICE_POT_Prompt.md) | Example RICE-POT prompt |
| [`02_Promblem_statements.md`](02_Promblem_statements.md) | Problem statement reference |
| [`03_Anti_Hallucination.md`](03_Anti_Hallucination.md) | Guidance for reducing unsupported AI-generated claims |
| [`04_RICE_POT_Generic_QA_Template.md`](04_RICE_POT_Generic_QA_Template.md) | Reusable QA prompt template, including profiles for QA tasks, test plans, test cases, and automation |
| [`Selenium_Framework/`](Selenium_Framework/) | Java, Selenium, Maven, and TestNG automation framework |
| [`Testplan/`](Testplan/) | Draft Salesforce login and logout test-plan deliverables |

## Getting started

1. Review the RICE-POT framework references and select the prompt profile that fits your QA task.
2. Use the generic QA template to prepare or adapt a prompt for the task.
3. For Selenium framework prerequisites, supported configuration, and Maven commands, see [`Selenium_Framework/README.md`](Selenium_Framework/README.md).
4. For the draft Salesforce login/logout test plan and its PDF, see [`Testplan/README.md`](Testplan/README.md).

## Notes

- The Salesforce test plan is a draft planning document. It does not represent test execution results or independently verified Salesforce behavior.
- Confirm requirements, test-account authorization, production safeguards, and environment details with the responsible owner before executing production tests.
- Never commit credentials, access tokens, or other secrets.
