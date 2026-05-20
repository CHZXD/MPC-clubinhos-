# TODO - múltiplos dias e horários por célula

- [ ] Frontend (`frontend/admin.html`):
  - [ ] Criar select “Dia da Semana” + input `type="time"` + botão “Adicionar Horário”
  - [ ] Implementar lista dinâmica abaixo com itens “Dia - HH:MM” e botão “Remover”
  - [ ] Validar (não permitir vazio)
  - [ ] Resetar campos após adicionar
  - [ ] No submit do form principal, capturar lista e enviar JSON payload `horarios: [{dia, horario}, ...]` via fetch

- [ ] Backend (`backend/api-mapa`):
  - [ ] Atualizar entidade `Celula` para persistir lista de horários (múltiplos itens)
  - [ ] Criar DTOs para receber payload do frontend (`horarios`)
  - [ ] Atualizar `CelulaController` para POST/PUT receber DTO e mapear para a entidade
  - [ ] Garantir que os endpoints GET continuem retornando os dados no formato esperado para o frontend

- [ ] Teste:
  - [ ] Adicionar 2+ horários no frontend e conferir payload
  - [ ] Confirmar persistência/retorno via GET
  - [ ] Confirmar remoção de item funciona na UI
