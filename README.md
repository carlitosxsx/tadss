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

# 25/03/2026

- preemptar: remoção de uma thread do estado de running;
- qualquer objeto no java pode ser syncronized;
- semaphore indica quantas threads podem executar um trecho de código;
- mutex tem a mesma função do semaphore mas indicado somente uma thread
- thread.yield(): abrir mão da cpu para voltar para ready;

### revisão

- processo: programa em execução;
- thread: fluxo de execução dentro do processo;
- stack: área de memória da thread (variáveis locais e métodos);
- thread deamon: processo ou thread que não tem fim;
- prioridade: valor informado ao escalonador para ele levar em consideração no momento de escolher a thread;
- starvation: thread que não consegue tempo na cpu (morre de fome);
- condição de corrida: resultado final dependente da temporização imprevisível (corrida) dos eventos;
- escalonador cooperativo: threads tem que cooperar evitar thread selfish
- escalonador preemptivo: 