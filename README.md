<h1 align="center">🌐 MultiAuth – Login Unificado com Vários Provedores</h1>

<p align="center">
  <img src="https://raw.githubusercontent.com/seu-usuario/seu-repo/main/docs/banner.png" alt="MultiAuth Banner" width="800"/>
</p>

<p align="center">
  <b>Um sistema de autenticação moderno que integra múltiplos provedores de login (Google, GitHub, Facebook, LinkedIn) em um back-end robusto com <i>Spring Boot</i>.</b>
</p>

---

<h2>📖 Sobre o Projeto</h2>

<p>
O <b>MultiAuth</b> foi desenvolvido para centralizar e unificar autenticações de diferentes provedores de OAuth2, oferecendo uma arquitetura limpa e modular.  
Cada provedor possui sua própria implementação desacoplada, facilitando a manutenção e a adição de novos logins sociais no futuro.
</p>

---

<h2>🏗️ Arquitetura do Back-end</h2>

<p align="center">
  <img src="https://raw.githubusercontent.com/seu-usuario/seu-repo/main/docs/backend-structure.png" alt="Arquitetura do Back-end" width="450"/>
</p>

<p>
A arquitetura segue o padrão <b>Controller → Service → Repository → DTO</b>, separando claramente responsabilidades para cada provedor de autenticação.
</p>

<ul>
  <li>📌 <b>config/</b> – Contém classes de configuração de segurança, como <code>CorsConfig</code> e <code>SecurityConfig</code>.</li>
  <li>📌 <b>facebook/</b> – Implementação do login com Facebook, incluindo <code>FacebookController</code>, <code>FacebookService</code>, <code>FacebookRepository</code> e DTOs.</li>
  <li>📌 <b>github/</b> – Implementação do login com GitHub, com a mesma estrutura modular.</li>
  <li>📌 <b>google/</b> – Implementação do login com Google.</li>
  <li>📌 <b>linkedin/</b> – Implementação do login com LinkedIn.</li>
  <li>📌 <b>utils/</b> – Classes utilitárias, como <code>JwtToken</code> para geração e validação de tokens JWT.</li>
</ul>

---

<h2>⚡ Fluxo de Autenticação</h2>

<p align="center">
  <img src="https://raw.githubusercontent.com/seu-usuario/seu-repo/main/docs/auth-flow.png" alt="Fluxo de Autenticação" width="700"/>
</p>

<p align="center"><i>
Frontend (Angular) → API REST (Spring Boot) → Provedor OAuth2 → JWT → Frontend
</i></p>

---

<h2>🚀 Destaques</h2>

<ul>
  <li>🔑 Suporte a múltiplos provedores de login social.</li>
  <li>🔒 Geração e validação de JWT para autenticação segura.</li>
  <li>📂 Estrutura modular e organizada por provedores.</li>
  <li>⚡ Fácil expansão para novos serviços de login.</li>
  <li>🛡️ Integração com Spring Security e boas práticas de segurança.</li>
</ul>

---

<h2>📸 Demonstrações</h2>

<p align="center">
  <img src="https://raw.githubusercontent.com/seu-usuario/seu-repo/main/docs/demo-login.png" alt="Tela de Login" width="600"/>
</p>

---

<h2>📜 Licença</h2>

<p align="center">
  Este projeto está licenciado sob a <a href="https://opensource.org/licenses/MIT">MIT License</a>.
</p>
