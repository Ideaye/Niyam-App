"""Per-script display-form overrides for generated `name` / `sourceLabel` fields.

aksharamukha derives all scripts from the Devanagari masters with one uniform
Sanskrit-transliteration convention. Native print conventions differ per
language (2026-09-01 native-speaker review, forlater #1): Marathi/Hindi print
uses anusvara over conjunct nasals in titles, Telugu/Tamil titles take their
nominal endings, Kannada uses tadbhava forms for Gita/Upanishad, Bengali
matches the app's own filter-chip forms and uses Bengali digits in verse refs.

Applied AFTER generation by tools/generate_names.py, and once directly to the
shipped mantras.json — keep the two in sync by editing only this file. Order
matters within each list. Patterns are regexes; `(?=\\s|$|,)` = word-final.
"""
import re

OVERRIDES = {
    "devanagari": [
        ("महामृत्युञ्जय", "महामृत्युंजय"),
        ("मन्त्र", "मंत्र"),
        ("वन्दना", "वंदना"),
        ("माण्डूक्य", "मांडूक्य"),
        ("पाण्डव", "पांडव"),
        ("ब्रह्माण्ड", "ब्रह्मांड"),
        ("शङ्कराचार्य", "शंकराचार्य"),
        ("कलिसन्तरण", "कलिसंतरण"),
        ("बन्धुरात्मात्मनः", "बंधुरात्मात्मनः"),
        ("कुन्देन्दु", "कुंदेंदु"),
        ("वक्रतुण्ड", "वक्रतुंड"),
        ("कृष्ण अष्टकम्", "कृष्णाष्टकम्"),
        ("श्रेयान्स्वधर्मो", "श्रेयान् स्वधर्मः"),
    ],
    "telugu": [
        (r"మంత్ర(?=\s|$|,)", "మంత్రం"),
        (r"సహస్రనామ(?=\s|$|,)", "సహస్రనామం"),
        (r"స్తోత్ర(?=\s|$|,)", "స్తోత్రం"),
        (r"ఋగ్వేద(?=\s|$|,)", "ఋగ్వేదం"),
        (r"యజుర్వేద(?=\s|$|,)", "యజుర్వేదం"),
        (r"పురాణ(?=\s|$|,)", "పురాణం"),
        (r"మహాభారత(?=\s|$|,)", "మహాభారతం"),
        (r"పర్వ(?=\s|$|,)", "పర్వం"),
        ("భగవద్గీతా", "భగవద్గీత"),
        (r"గీతా(?=\s|$|,)", "గీత"),
        (r"వందనా(?=\s|$|,)", "వందనం"),
        ("ఉపనిషద్", "ఉపనిషత్తు"),
        ("హనుమాన చాలీసా", "హనుమాన్ చాలీసా"),
        (r"తులసీదాస(?=\s|$|,)", "తులసీదాస్"),
    ],
    "tamil": [
        # U+A789 (Latin-block colon) visarga → native āytam: font-fallback/tofu
        # risk on Tamil fonts (review S10). Also applied to text fields.
        ("꞉", "ஃ"),
        (r"மந்த்ர(?=\s|$|,)", "மந்திரம்"),
        (r"ஸ்தோத்ர(?=\s|$|,)", "ஸ்தோத்திரம்"),
        (r"ருக்வேத(?=\s|$|,)", "ரிக் வேதம்"),
        (r"யஜுர்வேத(?=\s|$|,)", "யஜுர் வேதம்"),
        (r"மஹாபாரத(?=\s|$|,)", "மகாபாரதம்"),
        (r"ப்ரஹ்மாண்ட புராண(?=\s|$|,)", "பிரம்மாண்ட புராணம்"),
        (r"ஸஹஸ்ரநாம(?=\s|$|,)", "ஸஹஸ்ரநாமம்"),
        (r"அனுஶாஸன பர்வ(?=\s|$|,)", "அனுஶாஸன பருவம்"),
        ("ஹனுமான சாலீஸா", "அனுமன் சாலீசா"),
        (r"துலஸீதாஸ(?=\s|$|,)", "துளசிதாசர்"),
        (r"ஆதி ஶங்கராசார்ய(?=\s|$|,)", "ஆதி சங்கரர்"),
        (r"புத கௌஶிக(?=\s|$|,)", "புத கௌஶிகர்"),
        ("பகவத்கீதா", "பகவத் கீதை"),
        (r"உபநிஷத்(?=\s|$|,)", "உபநிடதம்"),
    ],
    "kannada": [
        ("ಉಪನಿಷದ್", "ಉಪನಿಷತ್ತು"),
        ("ಭಗವದ್ಗೀತಾ", "ಭಗವದ್ಗೀತೆ"),
        (r"ಗೀತಾ(?=\s|$|,)", "ಗೀತೆ"),
        (r"ವಂದನಾ(?=\s|$|,)", "ವಂದನೆ"),
        ("ಯಾ ಕುಂದೇಂದುತುಷಾರಹಾರಧವಲಾ", "ಯಾ ಕುಂದೇಂದು ತುಷಾರಹಾರ ಧವಲಾ"),
        ("ಸರ್ವಧರ್ಮಾನ್ಪರಿತ್ಯಜ್ಯ", "ಸರ್ವಧರ್ಮಾನ್ ಪರಿತ್ಯಜ್ಯ"),
        ("ಶ್ರೇಯಾನ್ಸ್ವಧರ್ಮೋ", "ಶ್ರೇಯಾನ್ ಸ್ವಧರ್ಮಃ"),
        ("ಕೃಷ್ಣ ಅಷ್ಟಕಂ", "ಕೃಷ್ಣಾಷ್ಟಕಂ"),
        (r"ರಾಮ ರಕ್ಷಾ ಸ್ತೋತ್ರ(?=\s|$|,)", "ರಾಮರಕ್ಷಾ ಸ್ತೋತ್ರಂ"),
        ("ಹನುಮಾನ ಚಾಲೀಸಾ", "ಹನುಮಾನ್ ಚಾಲೀಸಾ"),
    ],
    "bengali": [
        ("উপনিষদ্", "উপনিষদ"),
        (r"রাম রক্ষা স্তোত্র(?=\s|$|,)", "রামরক্ষা স্তোত্রম্"),
        ("বুধ কৌশিক", "বুধকৌশিক"),
        ("কৃষ্ণ অষ্টকম্", "কৃষ্ণাষ্টকম্"),
    ],
    "gujarati": [
        ("મહામૃત્યુઞ્જય", "મહામૃત્યુંજય"),
        ("મન્ત્ર", "મંત્ર"),
        ("વન્દના", "વંદના"),
        ("બ્રહ્માણ્ડ", "બ્રહ્માંડ"),
        ("શઙ્કરાચાર્ય", "શંકરાચાર્ય"),
        ("પાણ્ડવ", "પાંડવ"),
        ("ઉપનિષદ્", "ઉપનિષદ"),
        ("વક્રતુણ્ડ", "વક્રતુંડ"),
        ("કલિસન્તરણ", "કલિસંતરણ"),
        (r"રામ રક્ષા સ્તોત્ર(?=\s|$|,)", "રામ રક્ષા સ્તોત્રમ્"),
    ],
}

_BN_DIGITS = str.maketrans("0123456789", "০১২৩৪৫৬৭৮৯")


def apply_overrides(script: str, value: str) -> str:
    for pattern, repl in OVERRIDES.get(script, []):
        value = re.sub(pattern, repl, value)
    return value


def bengali_digits(value: str) -> str:
    """Verse refs in Bengali sourceLabels use Bengali digits (review S11)."""
    return value.translate(_BN_DIGITS)
