# 04/03/2026
- thread main é iniciado quando o programa (main) é executado, é o ponto de partida.
- programa sequencial: executado passo a passo em sequencia
- start() não inicia uma thread, ela muda para o estado 'ready'
- scheduler coloca a thread no estado 'running' e não é possível ter controle sobre a ordem de execução
- após ser executada, a thread vira uma thread morta e não pode ser executada novamente
- thread são objetos
- processos terminados em 'd' são deamon, o que significa que são threads que não vão 'morrer'
- configurações (deamon, prioridade...) devem ser definidas antes do start()

# 11/03/2026

- thread tem três partes: 
    - núcleo do s.o., ou seja, o que executa;
    - código que ela tem que executar (execução do método run());
    - stack, ou seja, a memória das variáveis locais (área onde somente a thread que está executando, diferente do heap que é uma área comppartilhada entre outras threads)

- thread de plataforma (so);
- green thread: é menos usada pois foca em dispositivos com 1 núcleo;
- virtual thread (coroutines): N > 1;