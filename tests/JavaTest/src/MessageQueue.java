import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue<T> {

    // listas não são thread-safe e não irão lidar de forma adequada
    // com sincronizar o conteúdo que foi manipulado por
    // diferentes threads
    private ArrayList<T> queue = new ArrayList<>();
    private ReentrantLock lock = new ReentrantLock();

    public void enqueue(T message) {
        lock.lock();
        queue.add(message);
        lock.unlock();
    }
    public T dequeue() {
        lock.lock();
        try{
            if (queue.size() > 0){
                return queue.remove(0);
            }
            return null;
        } finally {
            lock.unlock();
        }

    }
}

// flexibilty: cada thread pode trabalhar sob seu próprio ritmo buscando
// mensagens na message queue

// decoupling: cada processo será criado com princípios independentes e
// o sistema não precisa parar com um todo se uma thread falhar

// ---

// Quando você deseja encapsular a lógica de criação de objetos
// para que o código cliente
// não precise saber qual classe concreta está sendo criada.

// ele desacopla as regras de criação de
// de objetos de um tipo do seu tipo modelo


