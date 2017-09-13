import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HuffmanTest
{
    public static void main(String[] args)
    {
        try
        {
            (new HuffmanTest()).init();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void init() throws IOException
    {
        int[] charFreq = new int[0xFFFF];
        BufferedReader br = new BufferedReader(new FileReader("NavySeal.txt"));

        int ch = -1;
        while((ch = br.read())!=-1)
        {
            charFreq[ch]++;
        }
        ArrayList<HuffmanNode> nodes = new ArrayList<>();

        for(int i = 0;i<charFreq.length;i++)
        {
            if(charFreq[i]!=0)
            {
                nodes.add(new HuffmanNode((char)i,charFreq[i]));
            }
        }

        nodes = quickSort(nodes);
        for(HuffmanNode nd : nodes)
            System.out.println(nd.freq);
    }

    public ArrayList<HuffmanNode> quickSort(ArrayList<HuffmanNode> lst)
    {
        ArrayList<HuffmanNode> sortedList = new ArrayList<>(lst.size());

        if(lst.size()>0)
        {
            HuffmanNode pivot = lst.get(lst.size()-1);
            int pivotFreq = pivot.freq;
            ArrayList<HuffmanNode> less = new ArrayList<>();
            ArrayList<HuffmanNode> greater = new ArrayList<>();
            for(int i = 0;i<lst.size();i++)
            {
                if(i == (lst.size()-1) )
                    continue;
                HuffmanNode cur = lst.get(i);
                if(cur.freq > pivotFreq)
                    greater.add(cur);
                else if(cur.freq <= pivotFreq)
                    less.add(cur);
            }
            less = quickSort(less);
            greater = quickSort(greater);

            less.add(pivot);
            less.addAll(greater);

            return less;
        }
        return lst;
    }

    public ArrayList<HuffmanNode> createHuffmanTree(ArrayList<HuffmanNode> nod)
    {
        ArrayList<HuffmanNode> tree = new ArrayList<>();
        for(int i = 0;i<nod.size();i++)
        {

        }
    }
    class HuffmanNode
    {
        char ch;
        int freq;
        HuffmanNode parent = null;

        public HuffmanNode(char pCh, int pFreq )
        {
            ch = pCh;
            freq = pFreq;
        }

        public HuffmanNode(char pCh, int pFreq, HuffmanNode par )
        {
            ch = pCh;
            freq = pFreq;
            parent = par;
        }
    }
}
