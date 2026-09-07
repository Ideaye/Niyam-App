# Devotional Tech in India — Research Pack

**Prepared:** 2026-08-28 · **Branch:** `discuss/devotional-tech` · **Status:** discussion input, not a plan
**Purpose:** source material for a NotebookLM study of (a) Indian devotional user behaviour, (b) the existing devotional-app market, (c) what we could build.

---

## 0. How to use this pack

1. Create a NotebookLM notebook called **"Devotional Tech India"**.
2. Add this file (`.md`) as a source.
3. Add the URLs in §7 as individual web sources — NotebookLM will read them itself, which gives you an independent read on my summaries rather than only my summaries.
4. Ask it the questions in §6.

**Read this pack adversarially.** It is deliberately organised so that the weak numbers are labelled as weak. The single most useful thing NotebookLM can do here is disagree with §2.4 and §3.3.

---

## 1. Confidence key

| Grade | Meaning |
|---|---|
| **[A]** | Measured / primary. Large-sample survey, regulator, government data, or audited filing. |
| **[B]** | Credible journalism. Reported by a reputable outlet — usually company-supplied numbers with editorial checking. |
| **[C]** | Directional only. Vendor blogs, market-research press releases, startup-database aggregation, SEO content. |

**Working rule: no [C] number goes into a deck, a plan, or a decision.** They are included to show the shape of the conversation, not to be relied on. A large share of what circulates about this category is [C] dressed as [A].

---

## 2. Part I — The Indian devotional user

### 2.1 The religiosity baseline [A]

Pew Research Center, *Religion in India: Tolerance and Segregation* (fieldwork Nov 2019 – Mar 2020, n = 29,999 adults, face-to-face, 17 languages):

- **59%** of Hindus pray daily
- **57%** of Hindus perform puja daily, at home or at a temple
- Sharp regional variance: **South Indian Hindus ~30%** daily prayer vs 59% nationally
- **84%** of Indian adults say religion is "very important" in their lives

**Caveat that matters:** the fieldwork is over six years old. It predates UPI saturation, the Ram Mandir consecration (2024), and Maha Kumbh 2025 — three events that plausibly moved both practice and its digital expression. Treat the *structure* as durable and the *levels* as stale.

**Implication.** The behaviour already exists, offline, at daily frequency, at population scale. Devotional tech is not creating a habit — it is intermediating one. That is a far easier product problem than habit creation, and a far harder differentiation problem, because the habit does not need you. A user who stops using your app does not stop praying.

### 2.2 The digital baseline

- ~**936M** internet users in India [C]
- More than half prefer browsing in their mother tongue; ~**73%** consume regional-language content [C]
- Average monthly data per user ~**24 GB** in 2025, up from **62 MB** in 2014 [B — government data via press]
- Tier 2/3 cities drive the majority of new commercial demand [C]

The reliable core beneath the soft numbers: **India is mobile-only, vernacular-first, and data-cheap.** Everything else here is directional.

### 2.3 The attention picture

- Indians average ~**3.2 hours/day** on social apps (Esya Centre, 2023) [B]
- **11–37%** of Indian adolescents show problematic/addictive social media use, depending on the measurement scale [B — peer-reviewed range, PMC]
- **Jan 2025:** draft DPDP rules require verifiable parental consent for under-18 social media use [A — policy]
- LocalCircles: 1 in 2 parents report a child addicted to social/OTT/gaming [C — self-selecting online panel, treat sceptically]
- 82.2% of Indian children aged 14–16 can use a smartphone; 76% use it for social media vs 57% for education [C]

**Implication.** There is a real, felt, and increasingly *policy-legible* attention problem in India. And essentially nobody in devotional tech is addressing it. Every funded player in the category is competing to add another feed, another notification, another livestream. **The category is part of the attention problem, not a response to it.**

This is the one place where Niyam already stands somewhere nobody else stands.

### 2.4 Money behaviour — the most important section in this pack

The macro framing is that India is a high-volume, low-ARPU market (pricing index ~0.6x global) [C]. That is true and mostly useless. The category's own numbers are far more instructive.

**Sri Mandir / AppsForBharat — the category leader, June 2025 [B, TechCrunch]:**

| Metric | Value |
|---|---|
| Lifetime downloads | 40M+ |
| Monthly active users | 3.5M |
| International MAU | ~90,000 |
| Revenue run rate | ~$12M/yr |
| Domestic ARPU | ₹600–800 (~$7–9) |
| International ARPU | ₹7,000 (~$81) |
| Diaspora share of revenue | ~20% |
| Temple take rate | 20–25% |
| 6-month retention (claimed) | ~55% |
| Tier-1 / tier-2 split | ~50/50 |
| Under-35 share (India) | 30% |
| Total raised | ~$53.4M over 7 rounds |
| Profitability target | 2027–28 |

**And from March 2023 [B, Tigerfeathers]:** 10M downloads, 3M MAU, ~$1M ARR, and — the key line — **nearly 20% of chadhava revenue came from under 2% of chadhava users.**

Three structural facts fall out:

**(1) It is a whale business, not a subscription business.** Revenue concentration resembles mobile gaming more than it resembles Spotify. The median user monetises at approximately zero. Any plan that assumes broad, modest, recurring payment from Indian devotional users is arguing against the only real data we have.

**(2) The diaspora user is worth ~10x the domestic user.** ₹7,000 vs ₹600–800. Prayer-to-offering conversion is 20–25% in India but ~50% in the US. ~20% of revenue comes from ~2% of MAU. **A product built in India and sold to the diaspora is a structurally different business from one sold in India** — different price points, different retention maths, different marketing. Most Indian faith-tech treats diaspora revenue as a happy accident rather than as the design target.

**(3) The funnel leaks catastrophically — and the retention claim needs interrogating.**

```
                 Mar 2023        Jun 2025        change
 Downloads        10M             40M+            4.0x
 MAU               3M              3.5M           1.17x
 MAU / downloads   30%             ~9%            collapsed
```

Downloads quadrupled; monthly actives rose 17%. MAU/downloads fell from ~30% to ~9%. That sits awkwardly beside a claimed **~55% six-month retention**. Both can be true only if the large majority of installs never enter a measured cohort at all — i.e. the retention figure is computed on activated users, not installs.

**This is the number to make NotebookLM argue about.** If ~9% is closer to the category's real engagement rate, then the download figures everyone quotes — including the "300% growth in devotional app downloads" [C] line — are measuring curiosity, not devotion.

### 2.5 The generational split

Two different products currently share one category label.

**The daily-practice core (roughly 40–60+).** Sri Mandir usage picks up at **4am** and peaks around **7am**, tracking a real prayer routine [B]. Users who try a feature in a given week are ~2x more likely to use it 7/7 days than once [B]. This cohort wants ritual fidelity, familiar navigation, and their own language. They punish redesigns.

**The seeking entrant (roughly 18–25).** Enters through astrology, kundli, compatibility, planetary remedies, "manifestation", angel numbers [C — but consistent across many sources and corroborated by Astrotalk's actual scale]. Framed by the sources as spirituality-as-customisable-coping-mechanism, and as a cultural reclamation move (Sanskrit, rudraksha, learning aarti from a grandmother).

Note that the second group's stated motivation — anxiety, overwhelm, need for grounding — is the same motivation that drives digital-wellbeing behaviour. Nobody has connected those two.

---

## 3. Part II — The market as it exists

### 3.1 Category map

```
FAITH TECH INDIA — FIVE STACKS

1. RITUAL TRANSACTION RAILS       e-puja · chadhava · darshan booking · prasad delivery
   Sri Mandir · VAMA · Utsav · DevDham · SmartPuja · 99Pandit
   -> Marketplace economics. Take rate 20-25%. Ops-heavy: real priests, real logistics,
      real fulfilment hubs. This is where nearly all the funding has gone.

2. ASTROLOGY MARKETPLACES         paid consultation minutes
   Astrotalk · InstaAstro · Melooha
   -> The only proven LARGE-scale monetisation in Indian faith tech. Talktime economics.
      An order of magnitude bigger than everything else here combined.

3. CONTENT & PRACTICE             aarti · bhajan · chalisa · Gita · guided meditation
   Sadhguru/Isha · Gita Press apps · T-Series Bhakti Sagar · long-tail Chalisa apps
   -> Enormous usage, almost no monetisation. Ad-supported, non-profit, or loss-leader.

4. DEVOTIONAL COMMERCE            malas · idols · rudraksha · subscription boxes
   Japam · Abhimantrit (DevDham) · in-app stores
   -> Best gross margin, worst defensibility. Amazon and every temple shop compete.

5. TEMPLE INFRASTRUCTURE          queue mgmt · e-hundi · donation rails · CRM
   Temple Connect · payment stacks (Easebuzz, Finlo) · state e-hundi programmes
   -> B2B / B2G. Slow, sticky, unglamorous, real. Least crowded.
```

### 3.2 Player snapshot

| Player | Founded | Scale | Funding | Model | Grade |
|---|---|---|---|---|---|
| **Sri Mandir** (AppsForBharat) | 2020 | 40M+ downloads, 3.5M MAU, ~$12M RR | ~$53.4M | e-puja + chadhava + astrology + commerce | B |
| **Astrotalk** | 2017 | 15,000+ astrologers, 40M+ users served | — (profitable) | Astrologer marketplace, per-minute | B |
| **VAMA** | 2020 | 250+ temples, 300+ astrologers | ~$7.4M | e-puja, e-darshan, astrology, commerce | B/C |
| **Utsav App** | 2021 | 100k+ active users, 10k communities | ₹42 Cr total | Virtual puja + physical prasad | B/C |
| **DevDham** ⚠️ **SHUT DOWN** | 2020 | claimed 500+ temples, 2,000 pandits, 18 states | ₹6 Cr seed (~$1M total) | Darshan + puja + donations + D2C | B |
| **InstaAstro** | 2021 | 5,000+ astrologers, 5M+ customers | ₹18.5 Cr | Astrology, subscription-leaning | C |
| **Temple Connect** | 2016 | 7,000+ temples onboarded | — | Temple infrastructure / B2B | C |
| **Japam** | 2022 | 300,000+ customers | — | D2C spiritual jewellery | C |
| **Melooha** | 2022 | 110+ countries | — | AI-personalised astrology | C |
| **Sadhguru / Isha** | — | 7.9M+ downloads; *Miracle of Mind* hit 1M in 15 hrs | non-profit | Free, volunteer-built, 12 languages | B |

### 3.3 The funding picture — and the thing it hides

- India FaithTech funding: **$4.3M (2023) → ~$50.7M (2024)** [C, Inc42-derived]
- Corroborated independently: **~$50.5M in India in 2024**; India is the **2nd largest religious-tech market by funding after the US**, and has taken **~15% of global religious-tech investment since 2020** [B, TechCrunch]
- Top 10 religious apps in India, H1 2025: **+60% MAU, +50% downloads** — while the global top 10 fell **15% MAU / 2% downloads** [B]
- Claims of "**900+ / 950+ spiritual tech startups**" and an "**India spiritual market worth $58.56bn growing ~10% CAGR**" are [C] aggregator figures. Do not repeat them as fact.

**The thing the funding narrative hides:**

**Astrotalk, FY25 [B]** — revenue **₹1,214 Cr** (+85% YoY from ₹656 Cr), adjusted PBT **₹285 Cr** (up ~125%), profit ~₹250 Cr, ARR ~**₹1,600 Cr** as of Aug 2025, IPO signalled.

That is roughly **an order of magnitude larger than the entire funded devotional-app cohort combined**, and it is *profitable* while Sri Mandir targets profitability in 2027–28.

**Astrology, not devotion, is what actually pays in Indian faith tech today.** Any thesis we write has to answer: why isn't this just a worse Astrotalk? And: are we confusing a large *cultural* market with a large *payable* market?

### 3.4 What users actually complain about [B/C — app-store review analysis]

- Aggressive upsell pop-ups and free-trial nags interrupting devotional flow
- Login loops
- Undelivered prasad / merchandise orders; unresponsive support
- Unclear priest vetting and quality moderation
- Broken gamification accounting ("I did not receive the Punya Mudra for 29 & 30 December")
- Redesigns that break familiar navigation — hits the older core hardest

**The pattern is the finding.** The characteristic failure mode of devotional tech is that **commerce contaminates the sacred moment**. Users tolerate paying. They resent being *sold to* mid-prayer. This is the most consistent and most actionable signal in the entire pack, and it is a design constraint, not a marketing one.

### 3.5 The trust problem [B]

- Government advisories on fake pilgrimage-booking sites; Ram Mandir consecration donation scams
- A live scriptural objection that remote puja is not valid puja — puja should be performed in the home, with a priest present, with fire and smoke
- "No refunds under any circumstances" identified as a scam marker on temple-mimicking sites
- The industry's verification answer so far is ad-hoc: live-stream the ritual over Zoom / private YouTube

Nobody has built the trust layer as a **product**. It exists today as a per-vendor promise, not as infrastructure. Given that the core transaction is "give a stranger money to do something religious you cannot witness", this is a striking omission.

---

## 4. Part III — What is not being built

### Gap 1 — Practice depth (sadhana), not ritual transaction
Every funded player converges on the same three things: e-puja, chadhava, astrology. All three are **episodic and transactional**. None of them deepen a practice over time. There is no product that takes a user from "I light a lamp" to "I have a sustained daily sadhana", with structure, progression, and accountability. Content apps (Isha, Gita Press) have the material but no progression system; transaction apps have the engagement but no depth.
**Why it's still open:** depth doesn't monetise per-event, and per-event is what the funding has rewarded.

### Gap 2 — Transmission (teaching, especially to children)
Real demand visible in the long tail: shloka memorisation apps, online shloka classes serving US/Canada/Dubai/Australia/Singapore, "Hindu parenting" content, animated dharmic stories, Gita podcasts. This is being served by tiny apps, webflow sites, and Zoom tutors — **no venture-backed player is here at all.**
**Why it's still open:** it's an education product wearing a religion label, and Indian faith-tech investors have been underwriting marketplaces.

### Gap 3 — The attention problem ← *Niyam already lives here*
3.2 hrs/day on social apps; a peer-reviewed adolescent problem-use range of 11–37%; draft parental-consent rules for under-18s. And the devotional category's response has been to build more feeds. **There is no meaningful product framing devotion as an answer to distraction** — which is precisely Niyam's premise ("a pause before the scroll").
**Why it's still open:** it is a *restraint* product in a category funded for *engagement*. The business models point in opposite directions.

### Gap 4 — The diaspora as a first-class market, not an ARPU accident
₹7,000 vs ₹600–800. 50% offering-conversion in the US vs 20–25% in India. Sri Mandir grew 25–30% MoM internationally after merely *opening access* in Jan 2025 — with, by its own account, no localisation-first design. Nobody has built **for** the diaspora: for the parent whose child does not speak the language, for the timezone-shifted aarti, for the person who wants to mark a festival 8,000 km from anyone who observes it.
**Why it's still open:** Indian founders build for the market they can see out the window, and diaspora revenue arrives unbidden, so it never becomes the brief.

### Gap 5 — Trust as infrastructure
Verified priests, verified temples, verifiable performance, escrow, refunds, dispute resolution, provenance of the offering. Today: per-vendor promises and a Zoom link. There is a plausible **arms-supplier** business here — the trust layer that every devotional marketplace needs and none can credibly self-certify.
**Why it's still open:** it's infrastructure, so it's slow, and it requires neutrality that a marketplace can't have.

### Gap 6 — Life events and samskaras
The high-stakes, high-spend, high-anxiety moments — death rites, shraddha, naming, thread ceremony, house-warming, first rice — are where families genuinely do not know what to do and will pay for competence. Currently served by WhatsApp groups, a family priest, and panic. No structured product.
**Why it's still open:** it's episodic (bad retention optics) and emotionally heavy (hard to market).

### Also unserved
The **#1 religious app in India is a Bible app** [B — Sri Mandir is #2 overall, #1 among Hindu apps]. India's non-Hindu faiths — ~200M Muslims, ~28M Christians, ~21M Sikhs — are almost entirely unaddressed by Indian faith-tech startups. Note this as a fact about where founders point, not as a recommendation.

---

## 5. Part IV — Candidate theses

Five, stated as bets, with their failure modes. **None of these is a recommendation yet** — they exist to be argued with.

### A. Niyam as a devotional habit OS
**Bet:** the pause before the scroll is a wedge, not a product. Own the moment of interrupted attention, then earn the right to own the daily practice around it.
**Who:** the 25–45 urban Indian who is both genuinely observant and genuinely losing hours to a phone.
**Why now:** nobody in devotional tech is on the restraint side; policy and public sentiment are moving toward attention as a legitimate problem.
**Money:** subscription — the one place in this category where subscription is defensible, because the value is continuous rather than episodic.
**Why it fails:** restraint products have brutal retention; the user who succeeds no longer needs you. Whale economics don't apply, so ARPU stays at Indian levels.
**Relation to Niyam:** this is the straight-line extension of what already exists.

### B. The dharma tutor (diaspora-first)
**Bet:** Gap 2 × Gap 4. The highest-willingness-to-pay user in this entire market is a diaspora parent who is afraid their child will lose the thread — and education is the one category where Indian families reliably spend.
**Who:** Hindu parents in the US/UK/UAE/Canada/Australia with children aged 4–14.
**Why now:** ₹7,000 ARPU is already demonstrated in this cohort for *transactions*; education commands more than transactions.
**Money:** subscription at diaspora price points (a real $10–15/mo, not ₹99), possibly with live classes on top.
**Why it fails:** education is hard, content-heavy, and slow; competing with grandparents, temples, and weekend schools that are free.
**Relation to Niyam:** adjacent, not extension. Shares content assets (mantras, meanings, 8 languages) and nothing else.

### C. The trust layer
**Bet:** Gap 5. Be the verification and escrow infrastructure the whole category needs — priest identity, temple authorisation, proof-of-performance, refunds.
**Money:** per-transaction fee on other people's transactions; B2B.
**Why it fails:** you need the marketplaces to adopt you, and the biggest one would rather self-certify. Classic chicken-and-egg with a slow clock.
**Relation to Niyam:** none. A different company.

### D. Sadhana companion — depth over breadth
**Bet:** Gap 1. One practice, done properly, over months — with structure, progression, teaching, and a real teacher behind it. The opposite of a feed.
**Money:** subscription; possibly guru/lineage partnership.
**Why it fails:** the addressable population that wants *structured* practice is far smaller than the one that wants a lamp to tap, and Isha gives away something adjacent for free at enormous scale.
**Relation to Niyam:** natural second act; shares the mantra library and the pause mechanic.

### E. Samskara — the life-event concierge
**Bet:** Gap 6. Show up competently at the moments families are most lost and most willing to spend.
**Money:** high-ticket transactions, ops-heavy.
**Why it fails:** episodic by nature; you rebuild demand every time; ops quality is the whole product and it's hard.
**Relation to Niyam:** none.

### What I would not build
- **Another e-puja / chadhava marketplace.** Sri Mandir has 40M downloads, ₹175 Cr of fresh capital, fulfilment hubs in 20 temple towns, and a 20–25% take rate. There is no wedge left at the transaction layer.
- **Another astrology marketplace.** Astrotalk is profitable at ₹1,214 Cr and heading for an IPO with 15,000 astrologers. This is over.
- **A devotional feed.** It contributes to the problem in §2.3 and monetises at content-app rates, i.e. near zero.

---

## 6. Part V — Questions to put to NotebookLM

Ask these against this pack **plus** the raw sources in §7:

1. Reconcile Sri Mandir's claimed ~55% six-month retention with an MAU/downloads ratio that fell from ~30% to ~9% between Mar 2023 and Jun 2025. Which figure is load-bearing?
2. Is the "India spiritual market = $58bn" claim traceable to any primary source, or is it circular citation between aggregators?
3. How much of Sri Mandir's revenue growth ($1M → $12M run rate) is new users vs deeper monetisation of the same whales?
4. What evidence exists that Indian devotional users will pay a *recurring subscription*, as opposed to per-event transactions?
5. Astrotalk is ~10x the rest of the category and profitable. What does it do that devotional apps don't — and is the difference the product or the perceived stakes of the question being asked?
6. What is the actual size and composition of the Hindu diaspora willing to pay $10–15/month, by country?
7. Where is the evidence for Gen Z Indian spirituality being a *paying* behaviour rather than a *content-consumption* behaviour?
8. Which of the six gaps in §4 has a company already attacking it that this pack missed?
9. What are the regulatory risks specific to devotional commerce in India — temple trust regulation, state control of religious endowments, DPDP, Play Store policy on religious content?
10. What does the failure record look like? Which Indian faith-tech startups have shut down or stalled, and why? *(This pack is missing survivorship-bias correction entirely — it is the biggest hole in it.)*
11. Is there any credible measurement of devotional app usage that is independent of company-supplied figures?
12. If the attention problem (§2.3) and the young-seeker motivation (§2.5) are the same underlying anxiety, what product follows from treating them as one thing?

---

## 7. Sources

### Primary / measured [A]
- Pew Research Center — *Religion in India: Tolerance and Segregation* (2021) — https://www.pewresearch.org/religion/2021/06/29/religion-in-india-tolerance-and-segregation/
- Pew — Religious practices in India — https://www.pewresearch.org/religion/2021/06/29/religious-practices-2/
- Pew — full report PDF — https://www.pewresearch.org/wp-content/uploads/sites/20/2021/06/PF_06.29.21_India.full_.report.pdf
- Smartphone use & addiction in school-going adolescents (peer-reviewed, PMC) — https://pmc.ncbi.nlm.nih.gov/articles/PMC11845006/

### Credible journalism [B]
- TechCrunch — Sri Mandir keeps investors hooked as digital devotion grows (Jun 2025) — https://techcrunch.com/2025/06/30/sri-mandir-keeps-investors-hooked-as-digital-devotion-grows
- TechCrunch — Sri Mandir digitizing India's devotional journey (Sep 2024) — https://techcrunch.com/2024/09/09/sri-mandir-is-on-a-quest-to-digitize-indias-devotional-journey/
- Tigerfeathers — 10 Million Users And Rising Fast (Mar 2023, deep dive) — https://www.tigerfeathers.in/p/10-million-users-and-rising-fast
- Business Standard — AppsForBharat ₹175 Cr Series C — https://www.business-standard.com/companies/start-ups/appsforbharat-raises-rs-175-crore-series-c-to-expand-devotion-platform-125063001067_1.html
- Outlook Business — Astrotalk 85% revenue growth FY25 — https://www.outlookbusiness.com/news/astrotalk-reports-85-revenue-growth-in-fy25-as-tier-i-cities-boost-platform-activity
- BW Disrupt — Astrotalk revenue ₹1,214 Cr — https://www.bwdisrupt.com/article/astrotalk-revenue-jumps-85-to-rs-1-214-cr-591016
- Inc42 — Utsav raises ₹36 Cr Series A — https://inc42.com/buzz/spiritual-tech-startup-utsav-raises-%E2%82%B936-cr-to-expand-temple-network/
- The National — Sadhguru's Miracle of Mind beat ChatGPT to 1M downloads — https://www.thenationalnews.com/news/uae/2025/03/15/indian-yogi-sadhgurus-free-meditation-app-beats-chatgpt-for-first-million-downloads/
- Storyboard18 — India's social media boom and youth screen time — https://www.storyboard18.com/digital/indias-social-media-user-boom-raises-concerns-over-youth-screen-time-88504.htm
- Tribune India — Centre alerts public about online pilgrim booking scams — https://www.tribuneindia.com/news/india/centre-alerts-public-about-online-booking-scams-targeting-pilgrims-tourists
- Deccan Herald — Ayodhya Ram temple: fake donation sites and VIP pass scams — https://www.deccanherald.com/amp/story/technology%2Fayodhya-ram-temple-consecration-beware-of-fake-donation-websites-vip-pass-online-scams-2856062
- Deccan Herald — How should India tackle social media addiction — https://www.deccanherald.com/opinion/how-should-india-tackle-social-media-addiction-3338946

### Analysis / secondary [B/C]
- The India Notes — Sri Mandir UX audit — https://newsletter.theindianotes.com/p/sri-mandir-ux-audit
- Inc42 — 9 spiritual tech startups transforming India's faith market — https://inc42.com/startups/9-spiritual-tech-startups-transforming-indias-faith-market/
- StartupTalky — Top spiritual tech startups in India — https://startuptalky.com/top-spiritual-tech-startups-india/
- Startup Chai — From temples to tech — https://www.startupchai.in/p/the-weekend-insight-from-temples-to-tech-how-india-s-spiritual-roots-are-seeding-startups
- Tracxn — Online puja services companies — https://tracxn.com/d/trending-business-models/startups-in-online-puja-services/__8VZJnvWJDnp82Ualx68PcG4Yeua___l9fK_bXaWBrOU/companies
- Sensor Tower — Sri Mandir India overview — https://app.sensortower.com/overview/com.mandir?country=IN
- Kimola — Sri Mandir Google Play feedback report (Hindi reviews) — https://kimola.com/reports/unlock-spiritual-insights-with-our-sri-mandir-app-feedback-report-google-play-hi-145283
- RedSeer — Tier 2+ cities and India's interactive media boom — https://redseer.com/articles/the-3-2bn-bharat-opportunity-how-tier-2-cities-are-driving-indias-interactive-media-boom/
- Adapty — State of in-app subscriptions 2025 — https://adapty.io/blog/state-of-in-app-subscriptions-2025-in-10-minutes/
- Adapty — Fastest-growing app markets 2026 — https://adapty.io/blog/fastest-growing-app-markets-2026/
- LocalCircles — children and social media addiction — https://www.localcircles.com/a/press/page/children-social-media-addiction/

### Directional only — do not cite as fact [C]
- Zixin India — Temple-tech boom — https://zixinindia.com/blogs/temple-tech-boom-the-rise-of-devotional-apps-in-india
- Market.us — Spiritual and devotional products market — https://market.us/report/spiritual-and-devotional-products-market/
- The Bridge Chronicle — Young Indians turning spiritual — https://www.thebridgechronicle.com/lifestyle/young-indians-spirituality-astrology-angel-numbers
- Divya India — Gen Z and Indian spirituality — https://www.divyaindia.com/blogs/blog/why-gen-z-is-returning-to-indian-spirituality-and-what-it-means
- Elite Asia — India digital and social media trends 2026 — https://www.eliteasia.co/digital-and-social-media-trends-in-india-in-2026/

### Diaspora / transmission demand signals (long-tail, qualitative)
- Sanskrit From Home — online shloka classes for children — https://www.sanskritfromhome.org/course-details/online-shloka-class-7188
- Memorize Shloka (App Store) — https://apps.apple.com/us/app/memorize-shloka/id6443863948
- ShlokaLoka — https://shlokaloka.com/
- AtmikApp — https://atmikapp.com/
- Desh Videsh — Hindu parenting in the USA — https://www.deshvidesh.com/hindu-parenting-in-the-usa-raising-dharmic-children-in-a-modern-world/

---

## 8. Known holes in this pack

Stated plainly so NotebookLM and we can attack them:

1. **No survivorship-bias correction.** Everything here is about companies that raised money and survived. The failure record is absent.
2. **No independent usage measurement.** Almost every engagement number traces back to the company that benefits from it.
3. **Pew data is 6+ years old** and predates the events most likely to have moved it.
4. **Nothing on unit economics of the ops layer** — what a fulfilment hub costs, what priest supply costs, what the real contribution margin on a chadhava is.
5. **Nothing on regulation** — state control of temple endowments varies enormously by state and is a live political issue.
6. **Nothing on non-Hindu Indian faiths**, despite a Bible app being the #1 religious app in India.
7. **Gen Z spirituality claims are almost entirely [C]** — trend pieces citing each other. The Astrotalk revenue line is the only hard corroboration.


---

## 9. Addendum — corrections and additions (2026-08-28, same day)

Recorded rather than silently rewritten.

### 9.1 CORRECTION — DevDham has shut down [B]
§3.2 originally listed DevDham as an active player. **It is dead.** DevDham (formerly DevDarshan) shut
down operations after founder exits, having raised ~$1M including a ₹6 Cr seed in Jan 2024. It claimed
500+ temples and 2,000 pandits across 18 states at its peak. The error came from relying on an Inc42
landscape piece that had not been updated. **This is exactly the survivorship-bias failure §8 warned
about, occurring inside the pack itself.**

### 9.2 The failure record — partially closing hole #1 [B]

| Company | Model | Raised | Outcome | Stated cause |
|---|---|---|---|---|
| **My Tirth India** | Pilgrimage/darshan aggregator — temples, priests, hotels, travel agents, astrologers in one platform | — | Shut down Aug 2024 | Funding crisis after the death of principal shareholder Subrata Roy (2023) |
| **DevDham / DevDarshan** | Live darshan + e-puja + donations + D2C commerce | ~$1M | Shut down | Founder exits following seed round |

**The pattern in the deaths is the same as the pattern in the survivors' costs: both failures were
ops-heavy, supply-side aggregators.** They needed temples, priests, hotels or logistics before they
could serve a single user. Sri Mandir survives that model only because it raised $53M and built its own
fulfilment hubs. **A team without capital and without an ops function should not attempt a supply-side
aggregator in this category.** This is now the single most decision-relevant finding in the pack.

### 9.3 Drik Panchang — an incumbent the pack missed [B]
**4.5M downloads**, free with IAP, ~1,200 downloads/day sustained. Covers tithi, nakshatra, yoga, karana,
festivals, fasting days, government holidays, auspicious timings, kundali generation, and regional
calendar variants (Bengali, Malayalam, Oriya, Tamil).

This materially damages any "Hindu festival calendar app" thesis. **The almanac layer is taken.** What
Drik Panchang does *not* do is tell a user how to actually perform an observance — it answers *when*,
never *how*. That gap is real, but it is a narrower gap than it looked before this addendum.

### 9.4 Diaspora sizing — replacing an estimate with data [A]
Pew Research Center (2024) and census-derived figures:

| Country | Hindu population | Note |
|---|---|---|
| United States | ~3,370,000 | ~1% of population |
| United Kingdom | ~1,067,000 | 1.6% of population (2021 census) |
| Canada | ~828,000 | 2.3% of population (2021) |
| Australia | ~684,000 | — |
| **Four-country total** | **~5,949,000** | — |

- **Indian American median household income: $151,200 (2023)** vs ~$105,600 for Asian-headed households
  overall and roughly half that for the US median. [A, Pew]
- Indian American population ~4.8–5.2M; **48% of Indian-alone adults are Hindu.**

This is a genuinely wealthy, concentrated, English-fluent, app-reachable population of ~6M in four
countries — and it is the population already paying Sri Mandir ₹7,000/yr against ₹600–800 domestically.

### 9.5 Demand evidence for transmission — and its incumbent [B]
Chinmaya Mission Bala Vihar (weekend children's dharma classes, pre-K–Grade 12, plus Hindi/Gujarati/
Telugu language classes) has grown in the Bay Area chapter alone **from 6 children in 1981 to over
2,150 students today**, running Sept–June on weekends across many chapters in the US and UK.

Read this two ways. It **proves** diaspora parents will commit real time and money to transmitting
dharma to their children. It also means the incumbent is **in-person, community-embedded, cheap, and
emotionally entrenched** — the hardest kind of competitor for an app to displace head-on. A product here
should assume it complements Bala Vihar rather than replaces it.

### 9.6 Additional sources
- Entrackr — My Tirth India shuts down — https://entrackr.com/2024/08/spiritual-startup-my-tirth-india-shuts-down-ops-due-to-lack-of-funds/
- The India Bizz — DevDham shuts down operations — https://theindiabizz.com/business-news/devotional-startup-devdham-shuts-down-operations/
- Pew Research Center — Indian Americans: A Survey Data Snapshot (2024) — https://www.pewresearch.org/2024/08/06/indian-americans-a-survey-data-snapshot/
- Pew — Indians in the U.S. fact sheet — https://www.pewresearch.org/race-and-ethnicity/fact-sheet/asian-americans-indians-in-the-u-s/
- Drik Panchang — Hindu Calendar (App Store) — https://apps.apple.com/us/app/hindu-calendar-drik-panchang/id1321271821
- AppBrain — Hindu Calendar Drik Panchang download stats — https://www.appbrain.com/app/hindu-calendar-drik-panchang/com.drikp.core
- Chinmaya Mission San Jose — About Bala Vihar — https://www.cmsj.org/bala-vihar/
- Chinmaya Mission WRC — Language classes — https://cmwrc.chinmayadc.org/chinmayam/programs/enrichment/language-2/
