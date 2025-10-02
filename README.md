# Trello API Automation

Java 17 + Maven + Rest-Assured + JUnit 5 ile Trello REST API senaryosu.

## Senaryo (Case Study)
Aşağıdaki akış otomatik test edilmiştir:
1. Trello üzerinde bir **board** oluştur
2. Board’a **iki kart** oluştur
3. Kartlardan **birini rastgele güncelle**
4. **Kartları sil**
5. **Board’u sil**

Gereksinimler: Java, Maven, Rest-Assured; proje GitHub’da paylaşılmalı. Kaynak: Testinium Case Study.  
> API referansı: `https://developer.atlassian.com/cloud/trello/rest/`  
> Key/Token alma: `https://trello.com/app-key`

## Kurulum

### 1) Gereksinimler
- JDK 17+
- Maven 3.8+

### 2) Trello KEY / TOKEN (zorunlu)
Kendi Trello hesabınızdan Key/Token üretin (login olduktan sonra `https://trello.com/app-key`).

Ortam değişkenlerini tanımlayın:

**Windows (kalıcı):**
```bat
setx TRELLO_KEY "YOUR_KEY"
setx TRELLO_TOKEN "YOUR_TOKEN"
