EcoCombustão

Aplicativo Android para cálculo e comparação de emissões de diferentes combustíveis.


Integrantes da Equipe

* Áleffy Kauê de Araujo
* Felipe Bernardo Batista de Macedo
* Ivauir Silva da Rocha



Descrição do Projeto

O EcoCombustão é um aplicativo Android desenvolvido para auxiliar usuários a entender o impacto ambiental de diferentes combustíveis a partir da análise de emissões estimadas de CO₂ geradas durante um trajeto.

O app permite que o usuário:

* Selecione o tipo de combustível (Gasolina, Etanol, Diesel, GNV).
* Insira a distância percorrida (em km).
* Visualize o total de CO₂ emitido.
* Compare combustíveis e receba recomendações sustentáveis baseadas em química da combustão.
* Selecione o tipo de Veicuço(Carros, Motos, Aviões, trens)

O objetivo principal é promover **consumo consciente**, **educação ambiental** e **melhores escolhas de mobilidade**, mostrando a relação direta entre combustíveis e reações químicas de combustão.

---

## 🔬 **Motivação**

A emissão de gases de efeito estufa é um dos grandes desafios atuais. Cada combustível possui uma reação química de combustão específica, liberando diferentes quantidades de CO₂.
Esse projeto transforma esses dados em um app simples, informativo e acessível.

---

## 🛠️ **Tecnologias Utilizadas**

* **Kotlin**
* **Android Studio**
* **Arquitetura MVVM**
* **ViewModel + LiveData/StateFlow**
* **Coroutines (viewModelScope)**
* **Retrofit (API REST)**
* **Navigation Component**
* **Safe Args**
* **Material Design 3**
* **Acessibilidade para leitores de tela**
* **Git + GitHub (branches e pull requests)**

---

## 🌐 **API Utilizada**

### **Carbon Interface API (emissões de CO₂)**

API pública para estimar emissões de veículos com base em:

* Tipo de combustível
* Distância percorrida
* Modelo/Tipo de veículo

A API retorna valores em toneladas ou quilogramas de CO₂.

---

## 🧪 **Como o Cálculo Funciona (Resumo Químico Simplificado)**

Cada combustível tem uma equação de combustão aproximada, por exemplo:

* **Gasolina (aprox. C₈H₁₈):**
  C₈H₁₈ + 12,5 O₂ → 8 CO₂ + 9 H₂O

* **Etanol (C₂H₆O):**
  C₂H₆O + 3 O₂ → 2 CO₂ + 3 H₂O

O app pega esses fatores químicos, combina com os dados da API e exibe:

✔ emissão total (kg CO₂)
✔ comparação entre combustíveis
✔ impacto ambiental da escolha

---

## 📲 **Funcionalidades**

* Interface simples e intuitiva
* Seleção de combustível
* Campo de distância percorrida
* Cálculo automático de emissões
* Tela de resultados
* Recomendações sustentáveis
* Comparações visuais
* Persistência momentânea de estados com ViewModel
* Tratamento de erros da API (rede, servidor, etc.)

---

## 🗂️ **Estrutura do Projeto**

```
app/
 ├─ data/
 │   ├─ model/
 │   ├─ remote/
 │   └─ repository/
 ├─ ui/
 │   ├─ home/
 │   ├─ result/
 │   └─ components/
 ├─ di/
 ├─ utils/
 └─ App.kt
```

---

## 🚀 **Como Executar o Projeto**

1. Clone o repositório:

   ```bash
   git clone https://github.com/usuario/ecocombustao.git
   ```
2. Abra no Android Studio.
3. Aguarde o Gradle sincronizar.
4. Execute no emulador ou dispositivo físico.

---

## 📦 **APK**

O arquivo APK está disponível na pasta:

```
/release/EcoCombustao.apk
```

Ou via link no GitHub Releases.

---

## 🖼️ **Prints do Aplicativo**

*(Adicione aqui depois)*

* Tela inicial
* Tela de cálculo
* Tela de resultados
* Comparação entre combustíveis

---

## 🧭 **Navegação**

O aplicativo utiliza:

* **Navigation Component**
* **NavHostFragment**
* **Safe Args para passagem de dados entre telas**

Fluxo:
**Home → Resultados → Comparação**

---

## ♿ **Acessibilidade**

* Labels descritivos para leitores de tela
* Cores contrastantes
* Navegação por gestos e teclado
* Ícones com `contentDescription`

---

## 👥 **Organização da Equipe**

* Planejamento das telas
* Divisão das camadas (ViewModel, Repository, UI)
* Branches por funcionalidade
* Pull Requests com revisão

---

## 🧩 **Desafios Enfrentados**

* Integração com API externa
* Tratamento de erros e estados Loading/Error
* Implementação da arquitetura MVVM
* Garantir responsividade para diversos dispositivos
* Implementação de acessibilidade

---

## 📚 **Licença**

Projeto criado para fins educacionais.
Licenciado sob MIT.

---

Se quiser, posso **adicionar emojis**, deixar o README mais **profissional**, ou adaptar para um **modelo acadêmico**. Quer alguma modificação?
